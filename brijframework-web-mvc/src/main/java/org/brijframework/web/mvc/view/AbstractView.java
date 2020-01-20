package org.brijframework.web.mvc.view;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.brijframework.web.mvc.bean.WebMvcBean;

public abstract class AbstractView implements View{
	private ServletRequest request;
	private ServletResponse response;
	private Map<String, Object> parameters;
	private String viewName;
	private String prefix;
	private String suffix;
	
	private WebMvcBean handler;
	
	public AbstractView(ServletRequest request,ServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	public abstract String getContentType();
	
	protected abstract void processed();

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	public ServletRequest getRequest() {
		return request;
	}
	
	public ServletResponse getResponse() {
		return response;
	}
	
	
	public void setRequest(ServletRequest request) {
		this.request = request;
	}
	
	public void setResponse(ServletResponse response) {
		this.response = response;
	}
	
	public Map<String, Object> getParameters() {
		return parameters;
	}
	
	public void setHandler(WebMvcBean handler) {
		this.handler = handler;
	}

	public WebMvcBean getHandler() {
		return handler;
	}

	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public String pageView() {
         return this.getPrefix()+"/"+this.getViewName()+getSuffix();
	}
	

}
