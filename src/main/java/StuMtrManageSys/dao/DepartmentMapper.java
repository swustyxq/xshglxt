package StuMtrManageSys.dao;

import java.util.List;

import StuMtrManageSys.model.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String deptName);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String deptName);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

	List<Department> selectAll();
}