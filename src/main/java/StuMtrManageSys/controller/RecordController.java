package StuMtrManageSys.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import StuMtrManageSys.model.Record;
import StuMtrManageSys.model.User;
import StuMtrManageSys.selfmodel.MtrRecordList;
import StuMtrManageSys.service.RecordService;

@Controller
@RequestMapping("/recordController")
public class RecordController {

    private RecordService recordService;

    public RecordService getRecordService() {
        return recordService;
    }

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @SuppressWarnings({ "rawtypes", "finally", "unchecked" })
    @RequestMapping("/applyRecord")
    public ModelAndView applyRecord(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        try {
            // 业务逻辑
            int id = recordService.addOneRecord(user.getUserId());

            if (id != 0) {
                map.put("detailId", id);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
            } else {
                map.put("detailId", id);
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
    
    @SuppressWarnings({ "rawtypes", "finally", "unchecked" })
    @RequestMapping("/findAllCheckInfo")
    public ModelAndView findAllCheckInfo(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        List<MtrRecordList> mtrRecordLists = null;
        try {
            // 业务逻辑
            mtrRecordLists = recordService.findAllCheckMsg();
            if (mtrRecordLists != null) {
                map.put("mtrRecordLists", mtrRecordLists);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
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
    
}
