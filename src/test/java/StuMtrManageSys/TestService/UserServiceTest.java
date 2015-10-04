package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.User;
import StuMtrManageSys.service.UserService;

/**.
 * 此类描述的是： 用户服务类测试
 * 
 * @author: 同路人小组
 * @version: 2015年1月14日 下午11:57:48
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class UserServiceTest {

	/**.
	 * userService:用户服务
	 * 
	 * @since Ver 1.1
	 */

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**.
	 * 此方法描述的是：测试通过用户主键查找用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:29
	 */

	@Test
	public void testFindUserByUserId() {
		User user = userService.findUserByUserId(1);
		assertNotNull(user);
	}

	/**.
	 * 此方法描述的是：测试插入用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:33
	 */

	@Test
	public void testInsertUser() {
		int id = (int) (Math.random() * 1000);
		User user, userTest;
		user = new User();
		user.setUserId(id);
		user.setUserLoginname("test");
		user.setUserName("test");
		user.setUserPassword("test");
		user.setUserDeptname("学习部");
		user.setUserType("普通用户");
		user.setUserAddress("测试");
		userService.insertUser(user);

		userTest = userService.findUserByUserId(id);
		assertEquals(user.getUserAddress(), userTest.getUserAddress());

	}

	/**.
	 * 此方法描述的是：测试更新用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:36
	 */

	@Test
	public void testUpdateUser() {
		int id = (int) (Math.random() * 1000);
		User user, userTest;
		user = new User();
		user.setUserId(id);
		user.setUserLoginname("test");
		user.setUserName("test");
		user.setUserPassword("test");
		user.setUserDeptname("学习部");
		user.setUserType("普通用户");
		user.setUserAddress("测试");
		userService.insertUser(user);
		user.setUserAddress("测试2"); 
		userService.updateUser(user); 
		userTest = userService.findUserByUserId(id);
		assertEquals(user.getUserAddress(), userTest.getUserAddress());
	}

	/**.
	 * 此方法描述的是：测试删除用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:39
	 */

	@Test
	public void testDeleteUser() {
		int id = (int) (Math.random() * 1000);
		User user;
		user = new User();
		user.setUserId(id);
		user.setUserAddress("测试");
		userService.insertUser(user);
		boolean statue=userService.deleteUser(id);
		assertTrue(statue);
	}

	/**.
	 * 此方法描述的是：测试登陆
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:42
	 */

	@Test
	public void testLogin() {
		User user = userService.login("1234", "1234");
		assertEquals(user.getUserLoginname(), "1234");
		assertEquals(user.getUserPassword(), "1234");
	}

	/**.
	 * 此方法描述的是：测试查找所有用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:45
	 */

	@Test
	public void testSelectAllUser() {
		List<User> users = userService.selectAllUser();
		assertNotNull(users);
	}

	/**.
	 * 此方法描述的是：通过用户名查找用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:48
	 */

	@Test
	public void testFindByUserName() {
		List<User> users = userService.findByUserName("小灰灰");
		assertNotNull(users);
	}

	/**.
	 * 此方法描述的是：测试通过部门查找用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:58:58
	 */

	@Test
	public void testFindByUserDept() {
		List<User> users = userService.findByUserDept("学习部");
		assertNotNull(users);
	}

	/**.
	 * 此方法描述的是：测试通过账号查找用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:59:01
	 */

	@Test
	public void testFindByUserLoginname() {
		List<User> users = userService.findByUserLoginname("20121170");
		assertNotNull(users);
	}

	/**.
	 * 此方法描述的是：测试通过用户类型查找用户
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月14日 下午11:59:06
	 */

	@Test
	public void testFindByUserType() {
		List<User> users = userService.findByUserType("普通用户");
		assertNotNull(users);
	}

}
