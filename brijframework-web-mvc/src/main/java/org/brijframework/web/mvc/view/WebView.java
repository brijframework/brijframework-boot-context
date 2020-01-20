package org.brijframework.web.mvc.view;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WebView extends AbstractView {
   
	
	public WebView(ServletRequest request, ServletResponse response) {
		super(request, response);
	}

	protected void processed() {
	}

	@Override
	public String getContentType() {
		return null;
	}
}
