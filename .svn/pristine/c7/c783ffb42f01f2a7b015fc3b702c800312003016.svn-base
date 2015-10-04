package StuMtrManageSys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import StuMtrManageSys.model.Department;
import StuMtrManageSys.service.DepartmentSevice;

@Controller
@RequestMapping("/departmentController")
public class DepartmentController {
	private DepartmentSevice departmentSevice;

	public DepartmentSevice getDepartmentSevice() {
		return departmentSevice;
	}

	@Autowired
	public void setDepartmentSevice(DepartmentSevice departmentSevice) {
		this.departmentSevice = departmentSevice;
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showAllDepartment")
    public ModelAndView showAllDepartment(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
        	List<Department> departments=departmentSevice.selectAllDepartment();
            if (departments != null) {
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
                map.put("departments", departments);
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
}
