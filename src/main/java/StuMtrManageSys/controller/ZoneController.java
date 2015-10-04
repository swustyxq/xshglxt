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

import StuMtrManageSys.model.Zone;
import StuMtrManageSys.service.ZoneService;

@Controller
@RequestMapping("/zoneController")
public class ZoneController {
	private ZoneService zoneService;

	public ZoneService geZoneService() {
		return zoneService;
	}

	@Autowired
	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/showAllZone")
	public ModelAndView showAllZone(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			List<Zone> zones = null;
			zones = zoneService.selectAllZone();
			if (zones != null) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("zones", zones);
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
	@RequestMapping("/addZone")
	public ModelAndView addZone(String zoneName,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		Zone zone=new Zone();
		zone.setZoneName(zoneName);
		try {
			// 业务逻辑
			boolean status;
			status = zoneService.insertZone(zone);
			if (status) {
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
	@RequestMapping("/findZoneByZoneId")
	public ModelAndView findZoneByZoneId(Integer zoneId,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			Zone zone = null;
			zone = zoneService.findZoneByZoneId(zoneId);
			if (zone != null) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("zone", zone);
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
