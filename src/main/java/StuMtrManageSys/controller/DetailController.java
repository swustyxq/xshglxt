package StuMtrManageSys.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import sun.reflect.generics.tree.IntSignature;
import StuMtrManageSys.model.Detail;
import StuMtrManageSys.model.DetailWithBLOBs;
import StuMtrManageSys.model.Returnsituation;
import StuMtrManageSys.model.User;
import StuMtrManageSys.selfmodel.BorrowAndReturnList;
import StuMtrManageSys.selfmodel.BorrowRecordList;
import StuMtrManageSys.selfmodel.MtrRecordList;
import StuMtrManageSys.selfmodel.ReturnMtrList;
import StuMtrManageSys.service.DetailService;
import StuMtrManageSys.service.MaterialService;
import StuMtrManageSys.service.ReturnSituationSevice;

@Controller
@RequestMapping("/detailController")
public class DetailController {

	private DetailService detailService;

	public DetailService getDetailService() {
		return detailService;
	}

	@Autowired
	public void setDetailService(DetailService detailService) {
		this.detailService = detailService;
	}

	private MaterialService materialService;

	public MaterialService getMaterialService() {
		return materialService;
	}

	@Autowired
	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}
	
	private ReturnSituationSevice returnService;
	
	public ReturnSituationSevice getReturnService() {
		return returnService;
	}
	@Autowired
	public void setReturnService(ReturnSituationSevice returnService) {
		this.returnService = returnService;
	}

	// 申请物资
	@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
	@RequestMapping("/applyDetail")
	public ModelAndView applyDetail(int detailRecordid, int detailMtrid,
			int detailMtrnum, String MtrPostil, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();

		try {
			// 业务逻辑
			detailService.addDetial(detailRecordid, detailMtrid, detailMtrnum,
					MtrPostil);
			map.put("result", Boolean.TRUE);
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	// 审核物资
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/checkDetail")
	public ModelAndView checkDetail(int detailId, boolean result, String rejectReason,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();

		try {
			// 业务逻辑
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			detailService.checkDetail(detailId,result,rejectReason,user.getUserId());
			map.put("result", Boolean.TRUE);
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/returnDetail")
	public ModelAndView returnDetail(int detailId, int detailReturnsituation) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();

		Map map = new HashMap();

		// 获取当前系统时间
		Date detailReturntime = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(detailReturntime);

		Detail detail = new Detail();
		detail.setDetailId(detailId);
		// 物资变为归还状态
		detail.setDetailReturnstate(1);
		detail.setDetailReturnsituation(detailReturnsituation);
		detail.setDetailReturntime(detailReturntime);

		try {
			// 业务逻辑
			// detailMapper.updateByPrimaryKeySelective(detail);
			map.put("result", Boolean.TRUE);
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
	@RequestMapping("/findAllDetail")
	public ModelAndView findAllDetail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		List<BorrowRecordList> details = null;
		try {
			// 业务逻辑
			details = detailService.findAllDetail();
			map.put("result", Boolean.TRUE);
			map.put("details", details);
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
	@RequestMapping("/deleteDetail")
	public ModelAndView deleteDetail(int detailId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			boolean statue = detailService.deleteDetail(detailId);
			if (statue) {
				map.put("result", Boolean.TRUE);
				map.put("message", "删除成功！");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出错！");
			}
			
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
	@RequestMapping("/updateDetail")
	public ModelAndView updateDetail(Integer situId,String situDescription,int detailId,String rejectReason,String detailPostil,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		DetailWithBLOBs detail=new DetailWithBLOBs();
		detail.setDetailId(detailId);
		detail.setDetailRejectreason(rejectReason);
		detail.setDetailPostil(detailPostil);
		Returnsituation returnsituation=new Returnsituation();
		returnsituation.setSituId(situId);
		returnsituation.setSituDescription(situDescription);
		try {
			// 业务逻辑
			boolean statue1=true,statue2=true;
			statue1= detailService.updateDetail(detail);
			if (situId>=0) {
				statue2= detailService.updateReturnSituation(returnsituation);
			}
			
			if (statue1&&statue2) {
				map.put("result", Boolean.TRUE);
				map.put("message", "更新成功！");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出错！");
			}
			
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	
	/*查找所有借还记录*/
	@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
	@RequestMapping("/findAllRecords")
	public ModelAndView findAllRecords(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		
		try {
			// 业务逻辑
			List <BorrowAndReturnList> borrowAndReturnLists = null;
			borrowAndReturnLists = detailService.findAllBaRRecords();
			if (borrowAndReturnLists != null) {
				map.put("list", borrowAndReturnLists);
				map.put("result", Boolean.TRUE);
				map.put("message", "查找！");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出错！");
			}
			
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	
	//获得所有审核通过还未审核的物资
	@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
	@RequestMapping("/obtainAllReturnMtr")
	public ModelAndView obtainAllReturnMtr(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		
		try {
			// 业务逻辑
			List <ReturnMtrList> returnMtrLists = null;
			returnMtrLists = detailService.findAllReturnMtr();
			List <Returnsituation> returnsituations = returnService.findAll();
			if (returnMtrLists != null) {
				map.put("returnsituations", returnsituations);
				map.put("returnMtrLists", returnMtrLists);
				map.put("result", Boolean.TRUE);
				map.put("message", "查找！");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出错！");
			}
			
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	
		//归还物资
		@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
		@RequestMapping("/returnMtr")
		public ModelAndView returnMtr(int mtrId,int  mtrNum, int situation,int detailId, 
				HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			MappingJacksonJsonView view = new MappingJacksonJsonView();
			Map map = new HashMap();
			try {
				materialService.updateMtrNum(mtrId, mtrNum);
				detailService.updateDetailReturn(detailId,situation);
				// 业务逻辑
				map.put("result", Boolean.TRUE);
				map.put("message", "查找！");
				
			} catch (Exception e) {
				map.put("result", Boolean.FALSE);
				e.printStackTrace();
			} finally {
				view.setAttributesMap(map);
				mav.setView(view);
				return mav;
			}
		}
}
