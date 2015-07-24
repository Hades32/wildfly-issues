package wftest.server.ejb.acre;

import wftest.common.IACREService;
import wftest.common.IStationService;
import wftest.common.Station;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ACREService implements IACREService {
	
	@javax.persistence.PersistenceContext(name="HW30Vserver")
	javax.persistence.EntityManager em1;

    @EJB
    private IStationService stationService;

    @Override
    public Station getStation() {		
	//+"-"+em1.getProperties().get("hibernate.ejb.persistenceUnitName").toString()
        return stationService.getStation("-"+em1.toString());
    }

}
