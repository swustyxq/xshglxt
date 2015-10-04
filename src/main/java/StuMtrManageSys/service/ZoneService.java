package StuMtrManageSys.service;
import java.util.List;

import StuMtrManageSys.model.Zone;

public interface ZoneService {
	 public Zone findZoneByZoneId(int zoneId);
	 
	 public boolean insertZone(Zone zone);

	 public void deleteByPrimaryKey(int zoneId);

	 public void updateByPrimaryKey(Zone record);
	 
	 public void updateByPrimaryKeySelective(Zone record);

	 public List<Zone> selectAllZone();

}
