package com.autolog.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.multipart.MultipartFile;

import com.autolog.model.FileParamMeta;
import com.autolog.model.HttpResquestRecord;
import com.autolog.model.ParamMeta;

public class HttpRequestParamLogUtils {

	private HttpRequestParamLogUtils() {
		throw new IllegalStateException("HttpRequestParamLogUtils class");
	}

	public static void handler(Logger logger, String className, HttpServletRequest request, Object[] parameter) {
		HttpResquestRecord httpResquestRecord = new HttpResquestRecord();
		httpResquestRecord.setAccept(request.getHeader("Accept"));
		httpResquestRecord.setClassName(className);
		httpResquestRecord.setContentType(request.getHeader("Content-Type"));
		httpResquestRecord.setContextPath(request.getContextPath());
		httpResquestRecord.setHttpMethod(request.getMethod());
		httpResquestRecord.setRemoteAddr(request.getRemoteAddr());
		httpResquestRecord.setUri(request.getRequestURI());
		httpResquestRecord.setForwardedFor(request.getHeader("X-FORWARDED-FOR"));

		List<ParamMeta<?>> body = new ArrayList<>();

		for (Object signatureArg : parameter) {
			Field[] declaredFields = signatureArg.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				if (field.getName().equals("serialVersionUID")) {
					continue;
				}
				try {

					if (field.get(signatureArg) instanceof InputStreamSource) {
						ParamMeta<FileParamMeta> paramMeta = new ParamMeta<>();
						paramMeta.setName(field.getName());
						paramMeta.setType(field.getType().getCanonicalName());
						String fileName = ((MultipartFile) field.get(signatureArg)).getOriginalFilename();
						byte[] content = ((MultipartFile) field.get(signatureArg)).getBytes();
						String contentStr = Base64.getEncoder().encodeToString(content);
						FileParamMeta fileParamMeta = new FileParamMeta();
						fileParamMeta.setFileName(fileName);
						fileParamMeta.setSize(new BigDecimal(content.length));
						fileParamMeta.setContent(contentStr);
						paramMeta.setValue(fileParamMeta);
						body.add(paramMeta);
					} else if (field.get(signatureArg) instanceof String) {
						ParamMeta<String> paramMeta = new ParamMeta<>();
						paramMeta.setName(field.getName());
						paramMeta.setType(field.getType().getCanonicalName());
						paramMeta.setValue((String) field.get(signatureArg));
						body.add(paramMeta);
					} else if (field.get(signatureArg) instanceof Number) {
						ParamMeta<Number> paramMeta = new ParamMeta<>();
						paramMeta.setName(field.getName());
						paramMeta.setType(field.getType().getCanonicalName());
						paramMeta.setValue((Number) field.get(signatureArg));
						body.add(paramMeta);
					} else if (field.get(signatureArg) instanceof Map) {

					} else if (field.get(signatureArg) instanceof Collection) {

					} else {
						ParamMeta<Object> paramMeta = new ParamMeta<>();
						paramMeta.setName(field.getName());
						paramMeta.setType(field.getType().getCanonicalName());
						paramMeta.setValue(field.get(signatureArg));
						body.add(paramMeta);
					}
				} catch (Exception e) {
					ExceptionPrintUtils.handler(logger, e);
				}
			}

		}
		httpResquestRecord.setBody(body);
		LoggerUtils.print(logger, httpResquestRecord,"request body");
	}

}
