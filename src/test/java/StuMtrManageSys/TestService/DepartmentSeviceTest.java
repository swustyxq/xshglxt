package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.Department;
import StuMtrManageSys.service.DepartmentSevice;

/**.
 * 此类描述的是： 测试部门服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月15日 下午10:41:04
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class DepartmentSeviceTest {

	/**.
	 * 变量 departmentSevice:TODO
	 */

	private DepartmentSevice departmentSevice;

	/**.
	 * 方法名： getDepartmentSevice 此方法描述的是：
	 * 
	 * @return DepartmentSevice：
	 * @author: 同路人小组
	 * @version: 2015年1月16日 上午12:12:53
	 */

	public DepartmentSevice getDepartmentSevice() {
		return departmentSevice;
	}

	/**.
	 * 方法名： setDepartmentSevice 此方法描述的是： 注入部门服务
	 * 
	 * @param departmentSevice
	 *            void：部门服务
	 * @author: 同路人小组
	 * @version: 2015年1月16日 上午12:14:12
	 */

	@Autowired
	public void setDepartmentSevice(DepartmentSevice departmentSevice) {
		this.departmentSevice = departmentSevice;
	}

	/**.
	 * 方法名： testSelectAllDepartment 此方法描述的是 void： 测试查找所有部门 
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月16日 上午12:12:15
	 */

	@Test
	public void testSelectAllDepartment() {
		List<Department> departments = departmentSevice.selectAllDepartment();
		assertNotNull(departments);
	}

}
