package org.brijframework.web.mvc.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brijframework.web.main.WebBrijframework;
import org.brijframework.web.mvc.bean.WebMvcBean;
import org.brijframework.web.support.WebMethod;

public class WebMvcBrijframework extends WebBrijframework{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doHandler(WebMethod type, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.err.println("Status :" + "OK");
		controller(new WebMvcBean(type,request,response));
	}

	public void controller(WebMvcBean webBean) throws Exception {
		
	}

}
