package StuMtrManageSys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Elvis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import StuMtrManageSys.model.User;
import StuMtrManageSys.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showUser")
	public ModelAndView showUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			if (user != null) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("user", user);
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出现出错！");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/showAllUser")
	public ModelAndView showAllUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			List<User> users = userService.selectAllUser();
			map.put("result", Boolean.TRUE);
			map.put("message", "success");
			map.put("users", users);
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/login")
	public ModelAndView login(String username, String password,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			System.out.println(username + "你妹啊！");
			User user = userService.login(username, password);
			if (user.getUserId() != null) {
				System.out.println("尼玛");
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "用户名或密码填写错误！");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		// 清空的session对象
		HttpSession session = request.getSession();
		try {
			// session = null; 使session对象为空
			session.invalidate(); // 此时的退出只是使session对象失效
			map.put("result", Boolean.TRUE);
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/changePSW")
	public ModelAndView changePSW(String OldPSW, String NewPSW,
			String ConfirmPSW, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		// 清空的session对象
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String loginname = user.getUserLoginname();

		try {
			// session = null; 使session对象为空
			// 此时的退出只是使session对象失效
			user = null;
			user = userService.login(loginname, OldPSW);
			if (user != null) {

				if (ConfirmPSW.equals(NewPSW)) {
					user.setUserPassword(NewPSW);
					userService.updateUser(user);

					session.invalidate(); // 使session对象失效
					session = request.getSession();
					session.setAttribute("user", user);

					map.put("result", Boolean.TRUE);
					map.put("message", "密码更改成功！");

					System.out
							.println("/**************************************/");
					System.out.println("密码更改成功了啊");
					System.out
							.println("/**************************************/");

				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "两次输入密码不一致！");
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "原密码输入不正确！");
			}

		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "系统错误！");
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/changeUserInfo")
	public ModelAndView ChangeUserInfo(String userName, String userDeptname,
			String userTelephone, String userAddress,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		// 清空的session对象
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		user.setUserName(userName);
		user.setUserDeptname(userDeptname);
		user.setUserTelephone(userTelephone);
		user.setUserAddress(userAddress);

		try {
            if(userTelephone.length() == 11 || userTelephone.length()== 6){
            	userService.updateUser(user);
    			session.invalidate(); // 使session对象失效
    			session = request.getSession();
    			session.setAttribute("user", user);
    			
    			map.put("result", Boolean.TRUE);
    			map.put("message", "信息更改成功！");
            }
            else {
            	map.put("result", Boolean.FALSE);
    			map.put("message", "电话信息格式不正确！");
			}
			

		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "系统错误！");
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/addUser")
	public ModelAndView addUser(String userLoginname, String userName,
			String userTelephone, String userPassword, String userType,
			String userDeptname, String userAddress, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = new User();
		user.setUserAddress(userAddress);
		user.setUserDeptname(userDeptname);
		user.setUserLoginname(userLoginname);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserTelephone(userTelephone);
		user.setUserType(userType);

		try {
			// 业务逻辑
			boolean statue = userService.insertUser(user);
			if (statue) {
				map.put("result", Boolean.TRUE);
				map.put("message", "增加成功！");
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "增加失败！");
			}

		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/updateUser")
	public ModelAndView updateUser(String userLoginname, String userName,
			String userTelephone, String userPassword, String userType,
			String userDeptname, String userAddress, Integer userId,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = new User();
		user.setUserAddress(userAddress);
		user.setUserDeptname(userDeptname);
		user.setUserId(userId);
		user.setUserLoginname(userLoginname);
		user.setUserName(userName);
		user.setUserTelephone(userTelephone);
		user.setUserType(userType);

		try {
			// 业务逻辑
			boolean statue = userService.updateUser(user);
			if (statue) {
				map.put("result", Boolean.TRUE);
				map.put("message", "修改成功！");
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "修改失败！");
			}

		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(Integer userId,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			if (userService.deleteUser(userId)) {
				map.put("result", Boolean.TRUE);
				map.put("message", "删除成功");
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出现出错！");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/searchMaterialByType")
	public ModelAndView searchMaterialByType(String type,String input,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		List<User> users = null;

			if(type.equals("用户名")) 
				users = userService.findByUserName(input);
			if(type.equals("用户类型")) 
				users = userService.findByUserType(input);
			if(type.equals("所属部门")) 
				users= userService.findByUserDept(input);
			if(type.equals("账号")) 
				users= userService.findByUserLoginname(input);
		try {
			// 业务逻辑
			if (users.size()!=0) {
				map.put("result", Boolean.TRUE);
				map.put("message", "查找成功");
				map.put("users", users);
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "未查找到此用户！");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
}
