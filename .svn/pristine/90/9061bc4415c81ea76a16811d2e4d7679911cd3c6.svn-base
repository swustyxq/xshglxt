package StuMtrManageSys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import StuMtrManageSys.model.Material;
import StuMtrManageSys.service.MaterialService;

/**
 * @author LJY
 * 
 */
@Controller
@RequestMapping("/materialController")
public class MaterialController {

	private MaterialService materialService;;

	public MaterialService getMaterialService() {
		return materialService;
	}

	@Autowired
	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/showAllMaterial")
	public ModelAndView showAllMaterial(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			List<Material> materials = null;
			materials = materialService.selectAllMaterial();
			if (materials != null) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("materials", materials);
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出现出错！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/addMaterial")
	public ModelAndView addMaterial(String mtrColor, String mtrDeptname,
			Integer mtrImportance, String mtrName, String mtrPostil,
			String mtrSize, Integer mtrStocknum, Integer mtrTotalnum,
			String mtrType, HttpServletRequest request) {
		Material material = new Material();
		material.setMtrColor(mtrColor);
		material.setMtrDeptname(mtrDeptname);
		material.setMtrImportance(mtrImportance);
		material.setMtrName(mtrName);
		material.setMtrPostil(mtrPostil);
		material.setMtrSize(mtrSize);
		material.setMtrStocknum(mtrStocknum);
		material.setMtrTotalnum(mtrTotalnum);
		material.setMtrType(mtrType);

		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			if (materialService.insertMaterial(material)) {
				map.put("result", Boolean.TRUE);
				map.put("message", "增加成功");
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
	@RequestMapping("/deletMaterial")
	public ModelAndView deletMaterial(Integer mtrId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			if (materialService.deleteMaterial(mtrId)) {
				map.put("result", Boolean.TRUE);
				map.put("message", "删除成功！");
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
	@RequestMapping("/updateMaterial")
	public ModelAndView updateMaterial(Integer mtrId, String mtrColor,
			String mtrDeptname, Integer mtrImportance, String mtrName,
			String mtrPostil, String mtrSize, Integer mtrStocknum,
			Integer mtrTotalnum, String mtrType, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		Material material = new Material();
		material.setMtrId(mtrId);
		material.setMtrColor(mtrColor);
		material.setMtrDeptname(mtrDeptname);
		material.setMtrImportance(mtrImportance);
		material.setMtrName(mtrName);
		material.setMtrPostil(mtrPostil);
		material.setMtrSize(mtrSize);
		material.setMtrStocknum(mtrStocknum);
		material.setMtrTotalnum(mtrTotalnum);
		material.setMtrType(mtrType);

		try {
			// 业务逻辑
			boolean statues = materialService.updateMaterial(material);
			if (statues) {
				map.put("result", Boolean.TRUE);
				map.put("message", "更新成功！");
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
	@RequestMapping("/findMtrByDeptAndType")
	public ModelAndView findMtrByDeptAndType(String mtrType, String mtrDept,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();

		Map map = new HashMap();
		try {
			List<Material> materials = materialService.findMtrByDeptAndType(
					mtrType, mtrDept);
			// 业务逻辑
			if (materials != null) {
				map.put("materials", materials);
				map.put("message", "success");
				map.put("result", Boolean.TRUE);
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
	@RequestMapping("/showOneMtr")
	public ModelAndView showOneMtr(int mtrId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();

		Map map = new HashMap();
		try {
			Material material = materialService.findByMaterialId(mtrId);
			// 业务逻辑
			if (material != null) {
				map.put("materials", material);
				map.put("message", "success");
				map.put("result", Boolean.TRUE);
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
	public ModelAndView searchMaterialByType(String type, String input,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		List<Material> materials=null;
		try {
			if(type.equals("物资名称")) 
				materials = materialService.findByMaterialName(input);
			if(type.equals("物资类型")) 
				materials = materialService.findByMaterialType(input);
			if(type.equals("所属部门")) 
				materials= materialService.findByMaterialDept(input);
			// 业务逻辑
			if (materials.size()!=0) {
				map.put("materials", materials);
				map.put("message", "success");
				map.put("result", Boolean.TRUE);
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "未查找到该物资！");
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
	@RequestMapping("/updateMtrNum")
	public ModelAndView updateMtrNum(int mtrId,int mtrNum,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			materialService.updateMtrNum(mtrId,mtrNum);
			map.put("result", Boolean.TRUE);
			map.put("message", "恢复物资数量成功！");
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
