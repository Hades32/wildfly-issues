package wftest.server.backend.vehicle;


import wftest.server.backend.PathResource;
import wftest.common.IACREService;
import wftest.common.Station;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path(PathResource.VEHICLE)
@Stateless
@LocalBean
public class VehicleResource {

    @EJB
    private IACREService acreService;

    @GET
    public String test() {
		Station station = acreService.getStation();
        return station.getName();
    }
}
