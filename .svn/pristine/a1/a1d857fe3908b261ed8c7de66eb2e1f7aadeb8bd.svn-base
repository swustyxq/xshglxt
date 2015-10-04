package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.Materialtype;
import StuMtrManageSys.selfmodel.MaterialtypeAndZone;
import StuMtrManageSys.service.MaterialtypeService;

/**
 * . 此类描述的是： 物资类型服务测试
 * 
 * @author: 同路人小组
 * @version: 2015年1月15日 下午9:58:47
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class MaterialtypeServiceTest {
	private MaterialtypeService materialtypeServiceTest;


	public MaterialtypeService getMaterialtypeServiceTest() {
		return materialtypeServiceTest;
	}
	@Autowired
	public void setMaterialtypeServiceTest(
			MaterialtypeService materialtypeServiceTest) {
		this.materialtypeServiceTest = materialtypeServiceTest;
	}

	/**
	 * . 此方法描述的是：测试新增物资类型
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:59:28
	 */

	@Test
	public void testInsertMaterialtype() {
		Materialtype materialtype;
		int id;
		id = (int) (Math.random() * 1000);
		materialtype = new Materialtype();
		materialtype.setTypeName(id + "");
		materialtype.setTypeZoneid(1);
		boolean statue = materialtypeServiceTest
				.insertMaterialtype(materialtype);
		assertTrue(statue);

	}

	/**
	 * . 此方法描述的是：测试删除物资类型
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:59:31
	 */

	@Test
	public void testDeleteMaterialtype() {
		Materialtype materialtype;
		int id;
		id = (int) (Math.random() * 1000);
		materialtype = new Materialtype();
		materialtype.setTypeName(id + "");
		materialtype.setTypeZoneid(1);
		List<Materialtype> materialtypes = materialtypeServiceTest
				.selectAllMateriatypel();
		materialtypeServiceTest.insertMaterialtype(materialtype);
		materialtypeServiceTest.deleteMaterialtype(materialtype);
		List<Materialtype> materialtypes1 = materialtypeServiceTest
				.selectAllMateriatypel();
		assertEquals(materialtypes.size(), materialtypes1.size());
	}

	/**
	 * . 此方法描述的是：测试更新物资类型
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:59:36
	 */

	@Test
	public void testUpdateMaterialtype() {
		Materialtype materialtype;
		int id;
		id = (int) (Math.random() * 1000);
		materialtype = new Materialtype();
		materialtype.setTypeName(id + "");
		materialtype.setTypeZoneid(1);
		materialtypeServiceTest.insertMaterialtype(materialtype);
		materialtype.setTypeZoneid(2);
		boolean statue = materialtypeServiceTest
				.updateMaterialtype(materialtype);
		assertTrue(statue);
	}

	/**
	 * . 此方法描述的是：测试查找所有物资类型
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:59:39
	 */

	@Test
	public void testSelectAllMateriatypel() {
		List<Materialtype> materialtypes = materialtypeServiceTest
				.selectAllMateriatypel();
		assertNotNull(materialtypes);
	}

	/**
	 * . 此方法描述的是：测试显示所有物资类型及所在区域
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午9:59:42
	 */

	@Test
	public void testSelectAllMaterialtypeAndZone() {
		List<MaterialtypeAndZone> materialtypes = materialtypeServiceTest
				.selectAllMaterialtypeAndZone();
		assertNotNull(materialtypes);
	}

}
