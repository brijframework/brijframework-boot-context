package org.brijframework.web.mvc.model;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.brijframework.web.mvc.bean.WebMvcBean;
import org.brijframework.web.mvc.view.WebView;

public class WebModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletRequest request;
	private ServletResponse response;
	private Map<String, Object> parameters;
	private WebMvcBean handler;
	public  WebView view;
	
	public void setView(WebView view) {
		this.view = view;
	}
	
	public WebView getView() {
		return view;
	}

	public void setHandler(WebMvcBean handler) {
		this.handler = handler;
	}

	public WebMvcBean getHandler() {
		return handler;
	}

	public WebModel(ServletRequest request, ServletResponse response) {
		this.setRequest(request);
		this.setResponse(response);
	}

	public WebModel() {
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public void setResponse(ServletResponse response) {
		this.response = response;
	}

	public void setRequest(ServletRequest request) {
		this.request = request;
		if(this.request!=null){
			Map<String,Object> params=new HashMap<String, Object>();
			Enumeration<String> enumeration=request.getParameterNames();
			while(enumeration.hasMoreElements()){
				String key=enumeration.nextElement();
				params.put(key, request.getParameter(key));
			}
			setParameters(params);
		}
	}

	public ServletRequest getRequest() {
		return request;
	}

	public ServletResponse getResponse() {
		return response;
	}

}
