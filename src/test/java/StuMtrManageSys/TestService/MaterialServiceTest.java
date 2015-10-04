package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.Material;
import StuMtrManageSys.service.MaterialService;

/**
 * @author LJY
 *
 */

/**.
 * 此类描述的是： MaterialService测试
 * 
 * @author: 同路人小组
 * @version: 2015年1月14日 下午9:44:33
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class MaterialServiceTest {


	  
	/**   .
	 * 变量  materialService:物资管理服务 
	 */   
	    
	private MaterialService materialService;


	  
	/**  . 
	 * 方法名：  getMaterialService
	 * 此方法描述的是：   获取物资管理服务 
	 * 
	 * @return MaterialService：物资管理服务 
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:19:07   
	 */   
	    
	public MaterialService getMaterialService() {
		return materialService;
	}

	  
	/** .  
	 * 方法名：  setMaterialService
	 * 此方法描述的是：   
	 * 
	 * @param materialService void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:08:27   
	 */   
	    
	@Autowired
	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}  
	/** .  
	 * 方法名：  testFindByMaterialId
	 * 此方法描述的是：   通过物资主键查找物资
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:08:05   
	 */   
	    
	@Test
	public void testFindByMaterialId() {
		Material materialtest, material = new Material();
		int id;
		id=(int) (Math.random()*1000);
		material.setMtrId(id);
		material.setMtrName("测试");
		materialService.insertMaterial(material);
		materialtest = materialService.findByMaterialId(id);
		assertEquals(material.getMtrName(), materialtest.getMtrName());
	}
	  
	/** .  
	 * 方法名：  testInsertMaterial
	 * 此方法描述的是：   测试新增物资
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:08:53   
	 */   
	    
	@Test
	public void testInsertMaterial() {
		Material materialtest, material = new Material();
		int id;
		id=(int) (Math.random()*1000);
		material.setMtrId(id);
		material.setMtrName("测试");
		materialService.insertMaterial(material);
		materialtest = materialService.findByMaterialId(id);
		assertEquals(material.getMtrName(), materialtest.getMtrName());
	}

	/**  . 
	 * 方法名：  testDeleteMaterial
	 * 此方法描述的是：   测试删除物资
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:09:18   
	 */   
	@Test
	public void testDeleteMaterial() {
		Material materialtest = new Material(), material;
		int id = (int) (Math.random() * 1000);
		materialtest.setMtrId(id);
		materialService.insertMaterial(materialtest);
		materialService.deleteMaterial(materialtest.getMtrId());
		material = materialService.selectByPrimaryKey(materialtest);
		assertEquals(material, null);
	}

	/**.
	 * 方法名： testUpdateMaterial 此方法描述的是： 测试更新物资信息 void：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月16日 上午12:09:38
	 */
	@Test
	public void testUpdateMaterial() {
		Material materialtest = new Material(), material=new Material();
		int id = (int) (Math.random() * 1000);
		materialtest.setMtrId(id);
		materialtest.setMtrName("测试");
		materialService.insertMaterial(materialtest);
		materialtest.setMtrName("测试1");
		materialService.updateMaterial(materialtest);
		material = materialService.findByMaterialId(id);
		assertEquals(material.getMtrName(), materialtest.getMtrName());
	}

	@Test
	public void testupdateMtrNum() {
		Material materialtest = new Material(), material=new Material();
		int id = (int) (Math.random() * 1000);
		materialtest.setMtrId(id);
		materialtest.setMtrName("测试");
		materialService.insertMaterial(materialtest);
		boolean statue=materialService.updateMtrNum(id, 1000);
		assertTrue(statue);
	}
	/**.
	 * 此方法描述的是： 测试查询所有物资
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午9:48:52
	 */

	@Test
	public void testSelectAllMaterial() {
		List<Material> materials = materialService.selectAllMaterial();
		assertNotNull(materials);
	}

	/**.
	 * 此方法描述的是： 测试通过物资主键查询物资
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午9:49:30
	 */

	@Test
	public void testSelectByPrimaryKey() {
		Material materialtest, material = new Material();
		int id;
		id=(int) (Math.random()*1000);
		material.setMtrId(id);
		material.setMtrName("测试");
		materialService.insertMaterial(material);
		materialtest = materialService.selectByPrimaryKey(material);
		assertEquals(material.getMtrName(), materialtest.getMtrName());
	}

	/**.
	 * 此方法描述的是： 测试通过部门和类型查询物资
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午9:49:57
	 */

	@Test
	public void testFindMtrByDeptAndType() {
		List<Material> materials = materialService.findMtrByDeptAndType("灰灰",
				"学习部");
		assertNotNull(materials);
	}

	/**.
	 * 此方法描述的是： 测试通过物资名字查询物资信息
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午9:50:25
	 */

	@Test
	public void testFindByMaterialName() {
		List<Material> materials = materialService.findByMaterialName("小灰灰");
		assertNotNull(materials);
	}

	/**.
	 * 此方法描述的是： 测试通过物资类型查找物资
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午9:52:08
	 */

	@Test
	public void testFindByMaterialType() {
		List<Material> materials = materialService.findByMaterialType("灰灰");
		assertNotNull(materials);
	}

	/**.
	 * 此方法描述的是： 测试通过部门查找物资
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午9:52:46
	 */

	@Test
	public void testFindByMaterialDept() {
		List<Material> materials = materialService.findByMaterialDept("学习部");
		assertNotNull(materials);
	}

}
