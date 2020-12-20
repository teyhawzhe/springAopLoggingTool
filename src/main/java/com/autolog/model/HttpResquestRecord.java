package com.autolog.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class HttpResquestRecord implements Serializable {

	private static final long serialVersionUID = 4834043798442636912L;

	private String className;

	private String accept;

	private String contentType;

	private String httpMethod;

	private String contextPath;

	private String uri;

	private String remoteAddr;

	private String forwardedFor;

	private List<ParamMeta<?>> body;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getForwardedFor() {
		return forwardedFor;
	}

	public void setForwardedFor(String forwardedFor) {
		this.forwardedFor = forwardedFor;
	}

	public List<ParamMeta<?>> getBody() {
		return body;
	}

	public void setBody(List<ParamMeta<?>> body) {
		this.body = body;
	}

	@Override
	public String toString() {
		ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.JSON_STYLE);
		return ReflectionToStringBuilder.toString(this);
	}

}
