package StuMtrManageSys.dao;

import java.util.List;

import StuMtrManageSys.model.Zone;

public interface ZoneMapper {
    int deleteByPrimaryKey(Integer zoneId);

    int insert(Zone record);

    int insertSelective(Zone record);

    Zone selectByPrimaryKey(Integer zoneId);

    int updateByPrimaryKeySelective(Zone record);

    int updateByPrimaryKey(Zone record);
    List<Zone> selectAllZone();
}