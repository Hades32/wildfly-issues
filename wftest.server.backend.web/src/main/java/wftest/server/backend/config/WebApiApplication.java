package wftest.server.backend.config;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class WebApiApplication extends Application {

    public WebApiApplication() {
        super();
    }
/*	
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(wftest.server.backend.vehicle.VehicleResource.class);
        return s;
    }
*/
}
