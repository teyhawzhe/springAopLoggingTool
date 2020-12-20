package com.autolog.action.before.threadLocalInterceptor.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolog.action.before.threadLocalInterceptor.ThreadLocalInterceptor;
import com.autolog.properties.TheadLocalProperties;

public class DefaultThreadLocalInterceptor implements ThreadLocalInterceptor {

	@Autowired
	private TheadLocalProperties theadLocalProperties;

	@Override
	public void action(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		Thread thread = Thread.currentThread();

		try {
			Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
			threadLocalsField.setAccessible(true);
			Class<?> threadLocalMapKlazz = Class.forName("java.lang.ThreadLocal$ThreadLocalMap");
			Field tableField;
			tableField = threadLocalMapKlazz.getDeclaredField("table");
			tableField.setAccessible(true);
			Object threadLocals;

			threadLocals = threadLocalsField.get(thread);
			if (threadLocals != null) {
				Object table = tableField.get(threadLocals);
				if (table != null) {
					int threadLocalCount = Array.getLength(table);
					String threadName = thread.getName();

					for (int i = 0; i < threadLocalCount; i++) {
						Object entry = Array.get(table, i);
						if (entry instanceof Reference) {
							Field valueField = entry.getClass().getDeclaredField("value");
							valueField.setAccessible(true);
							Object value = valueField.get(entry);
							if (value != null) {
								for (String name : theadLocalProperties.getName()) {
									if (name.equals(value.getClass().getName())) {
										ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.JSON_STYLE);
										logger.info(value.getClass().getName() + " - " + ReflectionToStringBuilder.toString(value)); 
									}
								}
							}
						}
					}
				}
			}

		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			logger.error(e.getClass().getSimpleName().toString());
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));
			logger.error(stack.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getClass().getSimpleName().toString());
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));
			logger.error(stack.toString());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			logger.error(e.getClass().getSimpleName().toString());
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));
			logger.error(stack.toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.error(e.getClass().getSimpleName().toString());
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));
			logger.error(stack.toString());
		}
	}

}
