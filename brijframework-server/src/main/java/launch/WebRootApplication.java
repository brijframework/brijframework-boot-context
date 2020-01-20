package launch;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.brijframework.util.location.PathUtil;

public class WebRootApplication {
	public static String WEB_ROOT="/";
	public static String WEB_CLASSES="/WEB-INF/classes";
	public static String webapp="webapp";
	public static String target="classes";
	
	public int port;
	public Tomcat tomcat;
	
	public WebRootApplication() {
		this(8080);
	}
	
	public WebRootApplication(int port) {
		this.port=port;
	}
	
	public File webappDirLocation() {
		return PathUtil.resources(webapp);
	}
	
	public File additionWebInfClasses() {
		return PathUtil.resources(target);
	}
	
	public void start() throws Exception {
		tomcat = new Tomcat();
		tomcat.setPort(port);
		StandardContext ctx = (StandardContext) tomcat.addWebapp(WEB_ROOT, webappDirLocation().getAbsolutePath());
		WebResourceRoot resources = new StandardRoot(ctx);
		resources.addPreResources(new DirResourceSet(resources, WEB_CLASSES, additionWebInfClasses().getAbsolutePath(), WEB_ROOT));
	    ctx.setResources(resources);
	    tomcat.start();
	    tomcat.getServer().await();
	}

    public static void main(String[] args) throws Exception {
    	WebRootApplication application=new WebRootApplication(8089);
    	application.start();
    }
}
