package wftest.common;

import javax.ejb.Local;

@Local
public interface IStationService {
    Station getStation();
}
