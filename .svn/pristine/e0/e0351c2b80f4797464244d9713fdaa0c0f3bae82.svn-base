package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.Zone;
import StuMtrManageSys.service.ZoneService;

/**
 * . 此类描述的是： 区域服务测试
 * 
 * @author: 同路人小组
 * @version: 2015年1月15日 下午9:43:45
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class ZoneServiceTest {
	private ZoneService zoneService;

	public ZoneService getZoneService() {
		return zoneService;
	}

	@Autowired
	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	/**
	 * . 此方法描述的是： 测试通过主键查找区域
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:45:56
	 */

	@Test
	public void testFindZoneByZoneId() {
		Zone zone = new Zone(), testZone;
		Integer id;
		id = (int) (Math.random() * 1000);
		zone.setZoneId(id);
		zone.setZoneName("测试");
		zoneService.insertZone(zone);
		testZone = zoneService.findZoneByZoneId(id);
		assertEquals(zone.getZoneName(), testZone.getZoneName());
	}

	/**.
	 * . 此方法描述的是： 测试插入服务
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:48:42
	 */

	@Test
	public void testInsertZone() {
		Zone zone = new Zone(), testZone;
		Integer id;
		id = (int) (Math.random() * 1000);
		zone.setZoneId(id);
		zone.setZoneName("测试");
		zoneService.insertZone(zone);
		testZone = zoneService.findZoneByZoneId(id);
		assertEquals(zone.getZoneName(), testZone.getZoneName());

	}

	/**.
	 * . 此方法描述的是： 测试通过主键删除区域
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:49:30
	 */

	@Test
	public void testDeleteByPrimaryKey() {
		Zone zone = new Zone();
		Integer id;
		id = (int) (Math.random() * 1000);
		zone.setZoneId(id);
		zoneService.insertZone(zone);
		zoneService.deleteByPrimaryKey(id);
		Zone testZone = zoneService.findZoneByZoneId(id);
		assertNull(testZone);
		// assertEquals(zone.getZoneName(), testZone.getZoneName());
	}

	/**.
	 * . 此方法描述的是： 测试通过主键更新区域
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:50:01
	 */

	@Test
	public void testUpdateByPrimaryKey() {
		Zone zone = new Zone(), testZone;
		Integer id;
		id = (int) (Math.random() * 1000);
		zone.setZoneId(id);
		zone.setZoneName("测试1");
		zoneService.insertZone(zone);
		zone.setZoneName("测试2");
		zoneService.updateByPrimaryKey(zone);
		testZone = zoneService.findZoneByZoneId(id);
		assertEquals(zone.getZoneName(), testZone.getZoneName());
	}

	/**.
	 * . 此方法描述的是： 通过主键更新不为空内容
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:50:48
	 */

	@Test
	public void testUpdateByPrimaryKeySelective() {
		Zone zone = new Zone(), testZone;
		Integer id;
		id = (int) (Math.random() * 1000);
		zone.setZoneId(id);
		zone.setZoneName("测试1");
		zoneService.insertZone(zone);
		zone.setZoneName("测试2");
		zoneService.updateByPrimaryKeySelective(zone);
		testZone = zoneService.findZoneByZoneId(id);
		assertEquals(zone.getZoneName(), testZone.getZoneName());
	}

	/**.
	 * . 此方法描述的是： 查找所有区域
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:51:31
	 */

	@Test
	public void testSelectAllZone() {
		List<Zone> zones;
		zones = zoneService.selectAllZone();
		assertNotNull(zones);
	}

}
