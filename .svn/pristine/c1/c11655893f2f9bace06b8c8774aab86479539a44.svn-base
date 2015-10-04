package StuMtrManageSys.dao;

import java.util.List;

import StuMtrManageSys.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void updateByUserLoginName(User user);

    void deleteByUserLoginName(User user);

    User findUserByUAP(User user);

    List<User> selectAllUser();

	List<User> selectByUserName(String userName);

	List<User> selectByUserDept(String userDeptname);

	List<User> selectByLoginname(String userLoginname);

	List<User> selectByUserType(String userType);
}