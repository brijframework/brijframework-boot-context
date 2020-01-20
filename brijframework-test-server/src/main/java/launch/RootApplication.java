package launch;

import org.brijframework.web.tomcat.TomcatContext;

public class RootApplication {

    public static void main(String[] args) throws Exception {
    	TomcatContext application=new TomcatContext(8089);
    	application.start();
    }
}
