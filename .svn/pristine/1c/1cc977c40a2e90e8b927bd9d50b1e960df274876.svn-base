package StuMtrManageSys.service;

import java.util.List;

import StuMtrManageSys.model.User;

public interface UserService {
    public User findUserByUserId(int userId);

    public boolean insertUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(Integer userId);

    public User login(String username, String password);

    public List<User> selectAllUser();

	public List<User> findByUserName(String input);

	public List<User> findByUserDept(String input);

	public List<User> findByUserLoginname(String input);

	public List<User> findByUserType(String input);
}
