package servlet;

import javax.servlet.annotation.WebServlet;

import org.brijframework.web.mvc.bean.WebMvcBean;
import org.brijframework.web.mvc.main.WebMvcBrijframework;

@WebServlet(name = "hello", urlPatterns = { "/hello" })
public class HelloServlet extends WebMvcBrijframework {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void controller(WebMvcBean webBean) throws Exception {
		webBean.getResponse().getWriter().write("Hello Servlet");
		System.out.println(webBean.getModel().getParameters());
	}

}
