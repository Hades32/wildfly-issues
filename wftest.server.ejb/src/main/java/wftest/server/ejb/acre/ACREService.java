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

    @EJB
    private IStationService stationService;

    @Override
    public Station getStation() {
        return stationService.getStation();
    }

}
