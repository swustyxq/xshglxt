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

import StuMtrManageSys.model.Materialtype;
import StuMtrManageSys.selfmodel.MaterialtypeAndZone;
import StuMtrManageSys.selfmodel.UpdateMaterialType;
import StuMtrManageSys.service.MaterialtypeService;

/**
 * @author LJY
 * 
 */
@Controller
@RequestMapping("/materialtypeController")
public class MaterialtypeController {
	private MaterialtypeService materialtypeService;

	public MaterialtypeService getMaterialtypeService() {
		return materialtypeService;
	}

	@Autowired
	public void setMaterialtypeService(MaterialtypeService materialtypeService) {
		this.materialtypeService = materialtypeService;
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/showAllMaterialtype")
	public ModelAndView showAllMaterialtype(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			List<Materialtype> materialtypes=null;
			materialtypes = materialtypeService.selectAllMateriatypel();
			if (materialtypes != null) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("materialtypes", materialtypes);
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
	@RequestMapping("/showAllMaterialtypeAndZone")
	public ModelAndView showAllMaterialtypeAndZone(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			List<MaterialtypeAndZone> materialtypeAndZones=null;
			materialtypeAndZones = materialtypeService.selectAllMaterialtypeAndZone();
			if (materialtypeAndZones != null) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("materialtypeAndZones", materialtypeAndZones);
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
	@RequestMapping("/addMaterialtype")
	public ModelAndView addMaterialtype(String mtrType,Integer zoneId,
			HttpServletRequest request) {
		Materialtype materialType = new Materialtype();
		materialType.setTypeName(mtrType);
		materialType.setTypeZoneid(zoneId);
		
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			boolean statue=materialtypeService.insertMaterialtype(materialType);
			if (statue) {
				map.put("result", Boolean.TRUE);
				map.put("message", "增加成功！");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "该类型已经存在！");
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
	@RequestMapping("/deletMaterialtype")
	public ModelAndView deletMaterialtype(String mtrType,
			HttpServletRequest request) {
		Materialtype materialType = new Materialtype();
		materialType.setTypeName(mtrType);
		
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			materialtypeService.deleteMaterialtype(materialType);
			map.put("result", Boolean.TRUE);
			map.put("message", "删除成功");
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
	@RequestMapping("/updateMaterialtype")
	public ModelAndView updateMaterialtype(String pretypename,String typename,Integer zoneid,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		Materialtype materialtype=new Materialtype();
		materialtype.setTypeName(typename);
		materialtype.setTypeZoneid(zoneid);
		try {
			// 业务逻辑
			materialtypeService.updateMaterialtype(materialtype);
			map.put("result", Boolean.TRUE);
			map.put("message", "更新成功");
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
