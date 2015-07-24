package wftest.server.acre.station;

import wftest.common.IStationService;
import wftest.common.Station;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class StationService implements IStationService {
	
	@javax.persistence.PersistenceContext(name="HW30VserverACRE")
	javax.persistence.EntityManager em1;

	
    public Station getStation(String name){
		em1.toString();
		//em1.getProperties().get("hibernate.ejb.persistenceUnitName").toString()+
        return new Station("Station: "+"-"+em1.toString()+"-"+name);
    }
}
