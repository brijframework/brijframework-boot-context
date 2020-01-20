package org.brijframework.web.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController extends WebContent implements WebController {

	public Map<String, Object> response(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

}
