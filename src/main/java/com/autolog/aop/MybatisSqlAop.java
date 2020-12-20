package com.autolog.aop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class }),
		@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class MybatisSqlAop implements Interceptor {

	private static ThreadLocal<SimpleDateFormat> dateTimeFormatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object result = null;
		try {
			MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
			Object parameter = null;
			if (invocation.getArgs().length > 1) {
				parameter = invocation.getArgs()[1];
			}
			String sqlId = mappedStatement.getId();
			BoundSql boundSql = mappedStatement.getBoundSql(parameter);
			Configuration configuration = mappedStatement.getConfiguration();
			long startTime = System.currentTimeMillis();
			try {
				result = invocation.proceed();
			} finally {
				long endTime = System.currentTimeMillis();
				long sqlCostTime = endTime - startTime;
				// 取得sql
				String sql = this.getSql(configuration, boundSql);
				// 顯示log
				this.formatSqlLog(sqlId, sql, sqlCostTime, result);
			}
			return result;
		} catch (Exception e) {
			return result;
		}
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		}
		return target;
	}

	@Override
	public void setProperties(Properties properties) {
	}

	private String getSql(Configuration configuration, BoundSql boundSql) {
		// 取得 sql 樣板
		String sql = boundSql.getSql();
		if (StringUtils.isEmpty(sql)) {
			return "";
		}
		// 格式化sql樣板得出完整的sql
		return formatSql(sql, configuration, boundSql);
	}

	private String formatSql(String sql, Configuration configuration, BoundSql boundSql) {
		// 美化sql
		sql = beautifySql(sql);
		Object parameterObject = boundSql.getParameterObject();
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
		List<String> parameters = new ArrayList<>();
		if (parameterMappings != null) {
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					// 參數
					Object value = null;
					String propertyName = parameterMapping.getProperty();
					// 取得參數名稱
					if (boundSql.hasAdditionalParameter(propertyName)) {
						// 取得參數值
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						// 如果參數值只有一個
						value = parameterObject;
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					if (value instanceof Number) {
						parameters.add(String.valueOf(value));
					} else {
						StringBuilder builder = new StringBuilder();
						builder.append("'");
						if (value instanceof Date) {
							builder.append(dateTimeFormatter.get().format((Date) value));
						} else if (value instanceof String) {
							builder.append(value);
						}
						builder.append("'");
						parameters.add(builder.toString());
					}
				}
			}
		}
		for (String value : parameters) {
			sql = sql.replaceFirst("\\?", value);
		}
		return sql;
	}

	//
	private void formatSqlLog(String sqlId, String sql, long costTime, Object obj) {
		String sqlLog = "==> " + sql;
		StringBuilder result = new StringBuilder();
		if (obj instanceof List) {
			List<?> list = (List<?>) obj;
			int count = list.size();
			result.append("<==  Total: " + count);
		} else if (obj instanceof Integer) {
			result.append("<==  Total: " + obj);
		}
		result.append("  Spend Time ==> " + costTime + " ms");
		Logger log = LoggerFactory.getLogger(sqlId);
		log.info(sqlLog);
		log.info(result.toString());
		result.delete(0, result.length());
	}

	// 美化sql內多出來的空格與空行
	private static String beautifySql(String sql) {
		sql = sql.replaceAll("[\\s\n ]+", " ");
		return sql;
	}
}
