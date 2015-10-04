package StuMtrManageSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.dao.ZoneMapper;
import StuMtrManageSys.model.Zone;
import StuMtrManageSys.service.ZoneService;

  
/**   .
 * 类名：  ZoneServiceImpl 
 * 描述：  区域服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:52:39    
 */   
    
@Service("zoneService")
public class ZoneServiceImpl implements ZoneService {
	private ZoneMapper zoneMapper;

	public ZoneMapper getZoneMapper() {
		return zoneMapper;
	}

	@Autowired
	public void setZoneMapper(ZoneMapper zoneMapper) {
		this.zoneMapper = zoneMapper;
	}

	/*
	 * (non-Javadoc) Title: findZoneByZoneId Description:通过主键查找物资
	 * 
	 * @param zoneId区域主键
	 * 
	 * @return区域
	 * 
	 * @see StuMtrManageSys.service.ZoneService#findZoneByZoneId(int)
	 */
	@SuppressWarnings("finally")
	public Zone findZoneByZoneId(int zoneId) {
		Zone zone = new Zone();
		try {
			zone = zoneMapper.selectByPrimaryKey(zoneId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return zone;
		}
	}

	/*
	 * (non-Javadoc) Title: insertZone Description:增加区域
	 * 
	 * @param zone 将要增加的区域
	 * 
	 * @return 增加是否成功
	 * 
	 * @see
	 * StuMtrManageSys.service.ZoneService#insertZone(StuMtrManageSys.model.
	 * Zone)
	 */
	@SuppressWarnings("finally")
	public boolean insertZone(Zone zone) {
		try {
			zoneMapper.insert(zone);
		} catch (Exception e) {
			return false;
		} finally {
			return true;
		}
	}

	/*
	 * (non-Javadoc) Title: deleteByPrimaryKey Description:根据主键删除区域
	 * 
	 * @param zoneId 区域主键
	 * 
	 * @see StuMtrManageSys.service.ZoneService#deleteByPrimaryKey(int)
	 */
	@SuppressWarnings("finally")
	public void deleteByPrimaryKey(int zoneId) {
		try {
			zoneMapper.deleteByPrimaryKey(zoneId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return;
		}

	}

	/*
	 * (non-Javadoc) Title: updateByPrimaryKey Description:通过主键更新全部内容
	 * 
	 * @param record将要更新的内容
	 * 
	 * @see
	 * StuMtrManageSys.service.ZoneService#updateByPrimaryKey(StuMtrManageSys
	 * .model.Zone)
	 */
	@SuppressWarnings("finally")
	public void updateByPrimaryKey(Zone record) {
		try {
			zoneMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return;
		}

	}

	/*
	 * (non-Javadoc) Title: updateByPrimaryKeySelective Description:通过主键更新不为空内容
	 * 
	 * @param record 将要更新的内容
	 * 
	 * @see StuMtrManageSys.service.ZoneService#updateByPrimaryKeySelective(
	 * StuMtrManageSys.model.Zone)
	 */
	@SuppressWarnings("finally")
	public void updateByPrimaryKeySelective(Zone record) {
		try {
			zoneMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return;
		}
	}


	  
	/* (non-Javadoc)   
	 * Title: selectAllZone
	 * Description:
	 * @return
	 * @see StuMtrManageSys.service.ZoneService#selectAllZone()
	 */  
	@SuppressWarnings("finally")
	public List<Zone> selectAllZone() {
		List<Zone> list = null;
		try {
			list = zoneMapper.selectAllZone();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			return list;
		}
	}

}
