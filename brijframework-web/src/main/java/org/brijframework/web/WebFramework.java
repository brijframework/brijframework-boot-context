package org.brijframework.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.brijframework.web.support.WebMethod;

public interface WebFramework {

	 void doHandler(WebMethod type, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
