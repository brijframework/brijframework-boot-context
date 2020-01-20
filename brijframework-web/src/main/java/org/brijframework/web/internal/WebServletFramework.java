package org.brijframework.web.internal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brijframework.web.WebFramework;
import org.brijframework.web.support.WebMethod;

public abstract class  WebServletFramework extends HttpServlet implements WebFramework{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandler(WebMethod.DELETE, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			doHandler(WebMethod.GET, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandler(WebMethod.POST, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandler(WebMethod.HEAD, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandler(WebMethod.OPTION, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandler(WebMethod.PUT, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandler(WebMethod.TRACE, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
