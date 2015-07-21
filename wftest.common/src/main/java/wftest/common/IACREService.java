package wftest.common;

import javax.ejb.Local;

@Local
public interface IACREService {
    Station getStation();
}
