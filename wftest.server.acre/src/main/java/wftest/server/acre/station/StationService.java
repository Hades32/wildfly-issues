package wftest.server.acre.station;

import wftest.common.IStationService;
import wftest.common.Station;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class StationService implements IStationService {
    public Station getStation(){
        return new Station("xxxxxx");
    }
}
