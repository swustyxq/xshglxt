package StuMtrManageSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.dao.UserMapper;
import StuMtrManageSys.model.User;
import StuMtrManageSys.service.UserService;

  
/**.  
 * 类名：  UserServiceImpl 
 * 描述：  用户服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:53:00    
 */   
    
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/*
	 * (non-Javadoc) Title: findUserByUserId Description:通过主键查找用户
	 * 
	 * @param userId用户主键
	 * 
	 * @return用户对象
	 * 
	 * @see StuMtrManageSys.service.UserService#findUserByUserId(int)
	 */
	@SuppressWarnings("finally")
	public User findUserByUserId(int userId) {
		User user = new User();
		try {
			user = userMapper.selectByPrimaryKey(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return user;
		}
	}

	/*
	 * (non-Javadoc) Title: InsertUser Description:新增用户
	 * 
	 * @param user用户对象
	 * 
	 * @return新增用户是否成功
	 * 
	 * @see
	 * StuMtrManageSys.service.UserService#InsertUser(StuMtrManageSys.model.
	 * User)
	 */
	public boolean insertUser(User user) {
		try {
			userMapper.insert(user);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	  
	/* (non-Javadoc)   
	 * Title: login
	 * Description:登陆
	 * @param username账号
	 * @param password密码
	 * @return用户对象
	 * @see StuMtrManageSys.service.UserService#login(java.lang.String, java.lang.String)
	 */  
	@SuppressWarnings("finally")
	public User login(String username, String password) {
		User user = new User();
		try {
			user.setUserLoginname(username);
			user.setUserPassword(password);
			user = userMapper.findUserByUAP(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return user;
		}
	}

	  
	/* (non-Javadoc)   
	 * Title: updateUser
	 * Description:更新用户
	 * @param user用户
	 * @return更新是否成功
	 * @see StuMtrManageSys.service.UserService#updateUser(StuMtrManageSys.model.User)
	 */  
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			userMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	  
	/* (non-Javadoc)   
	 * Title: deleteUser
	 * Description:通过主键删除用户
	 * @param userId用户主键
	 * @return 删除是否成功
	 * @see StuMtrManageSys.service.UserService#deleteUser(java.lang.Integer)
	 */  
	public boolean deleteUser(Integer userId) {
		try {
			userMapper.deleteByPrimaryKey(userId);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;

	}

	/*
	 * (non-Javadoc) Title: selectAllUser Description:查找全部用户
	 * 
	 * @return用户列表
	 * 
	 * @see StuMtrManageSys.service.UserService#selectAllUser()
	 */
	@SuppressWarnings("finally")
	public List<User> selectAllUser() {
		List<User> users = null;
		try {
			users = userMapper.selectAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return users;
		}
	}

	/*
	 * (non-Javadoc) Title: findByUserName Description:通过名称查找用户
	 * 
	 * @param userName：用户名称
	 * 
	 * @return：用户列表
	 * 
	 * @see StuMtrManageSys.service.UserService#findByUserName(java.lang.String)
	 */
	@Override
	public List<User> findByUserName(String userName) {
		List<User> users = null;
		try {
			users = userMapper.selectByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/*
	 * (non-Javadoc) Title: findByUserDept Description:通过部门查找用户
	 * 
	 * @param userDeptname：部门名称
	 * 
	 * @return用户列表
	 * 
	 * @see StuMtrManageSys.service.UserService#findByUserDept(java.lang.String)
	 */
	@Override
	public List<User> findByUserDept(String userDeptname) {
		List<User> users = null;
		try {
			users = userMapper.selectByUserDept(userDeptname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/*
	 * (non-Javadoc) Title: findByUserLoginname Description:通过账号查找用户
	 * 
	 * @param userLoginname：用户账户
	 * 
	 * @return用户列表
	 * 
	 * @see
	 * StuMtrManageSys.service.UserService#findByUserLoginname(java.lang.String)
	 */
	public List<User> findByUserLoginname(String userLoginname) {
		List<User> users = null;
		try {
			users = userMapper.selectByLoginname(userLoginname);
		} catch (Exception e) {
			System.out.println(e);
		}
		return users;
	}

	/*
	 * (non-Javadoc) Title: findByUserType Description:按用户类型查找用户
	 * 
	 * @param userType：用户类型
	 * 
	 * @return 用户列表
	 * 
	 * @see StuMtrManageSys.service.UserService#findByUserType(java.lang.String)
	 */
	public List<User> findByUserType(String userType) {
		List<User> users = null;
		try {
			users = userMapper.selectByUserType(userType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
