package StuMtrManageSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.dao.DepartmentMapper;
import StuMtrManageSys.model.Department;
import StuMtrManageSys.service.DepartmentSevice;

/**
 * @author LJY
 *
 */
  
/**.   
 * 类名：  DepartmentSeviceImpl 
 * 描述：  部门服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:11:10    
 */   
    
@Service("departmentSevice")
public class DepartmentSeviceImpl implements DepartmentSevice{

	private DepartmentMapper departmentMapper;
	public DepartmentMapper getDepartmentMapper() {
		return departmentMapper;
	}
	@Autowired
	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}
	  
	/* (non-Javadoc)   
	 * Title: selectAllDepartment
	 * Description:查找所有部门
	 * @return  部门list集合
	 * @see StuMtrManageSys.service.DepartmentSevice#selectAllDepartment()
	 */  
	public List<Department> selectAllDepartment() {
		List<Department> departments = null;
		try {
			departments=departmentMapper.selectAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return departments;
	}

}
