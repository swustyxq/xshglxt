package StuMtrManageSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.dao.ReturnsituationMapper;
import StuMtrManageSys.model.Returnsituation;
import StuMtrManageSys.service.ReturnSituationSevice;

  
/**  . 
 * 类名：  ReturnSituationSeviceImpl 
 * 描述：  归还情况服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:53:16    
 */   
    
@Service("returnSituationSevice")
public class ReturnSituationSeviceImpl implements ReturnSituationSevice{

	private ReturnsituationMapper reMapper;
	
	public ReturnsituationMapper getReMapper() {
		return reMapper;
	}
	@Autowired
	public void setReMapper(ReturnsituationMapper reMapper) {
		this.reMapper = reMapper;
	}

	  
	/* (non-Javadoc)   
	 * Title: findAll
	 * Description:查找所有归还情况
	 * @return所有归还情况列表
	 * @see StuMtrManageSys.service.ReturnSituationSevice#findAll()
	 */  
	@SuppressWarnings("finally")
	public List<Returnsituation> findAll() {
		List<Returnsituation> reList = null;
		try {
			reList = reMapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return reList;
		}
	}

}
