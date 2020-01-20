package org.brijframework.web.mvc.bean;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.web.mvc.controller.WebController;
import org.brijframework.web.mvc.model.WebModel;
import org.brijframework.web.mvc.view.WebView;
import org.brijframework.web.support.WebMethod;

public class WebMvcBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected WebView view;

	protected WebController controller;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected WebMethod requesttype;

	private WebModel model;
	
	public WebMvcBean() {
	}
	
	public WebMvcBean(WebMethod requesttype,HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		this.response=response;
		this.requesttype=requesttype;
		this.inti();
	}
	
	private void inti() {
		this.setView(new WebView(request, response));
		this.setModel(new WebModel(request, response));
	}

	public void createView(Map<String, Object> map) {
		this.view = InstanceUtil.getSingletonInstance(WebView.class, map);
	}

	public void setView(WebView view) {
		this.view = view;
	}

	public WebView getView() {
		return view;
	}

	public WebController getController() {
		return controller;
	}

	public void setController(WebController controller) {
		this.controller = controller;
	}

	public void setModel(WebModel model) {
		this.model = model;
		if (this.model != null){
			model.setHandler(this);
		}
	}

	public WebModel getModel() {
		return model;
	}

	public void createModel(Map<String, Object> params) {
		this.model = InstanceUtil.getSingletonInstance(WebModel.class, params);
	}
	
	public void processing() {

	}
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	

}
