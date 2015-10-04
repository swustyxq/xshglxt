package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.Returnsituation;
import StuMtrManageSys.service.ReturnSituationSevice;

  
    /**  . 
     * 此类描述的是：   返还情况服务测试
     * @author: 同路人小组
     * @version: 2015年1月15日 下午11:25:39    
     */   
    
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class ReturnSituationSeviceTest {
	  
	    /**  . 
	     * returnSituationSevice:归还情况服务 
	     *   
	     * @since Ver 1.1   
	     */   
	    
	private ReturnSituationSevice returnSituationSevice;

	public ReturnSituationSevice getReturnSituationSevice() {
		return returnSituationSevice;
	}

	  
	    /**  . 
	     * 此方法描述的是：   注入服务
	     * @author: 同路人小组
	     * @version: 2015年1月15日 下午11:27:06   
	     */   
	    @Autowired
	public void setReturnSituationSevice(ReturnSituationSevice returnSituationSevice) {
		this.returnSituationSevice = returnSituationSevice;
	}

	  
	    /** .  
	     * 此方法描述的是：   查找所有归还情况
	     * @author: 同路人小组
	     * @version: 2015年1月15日 下午11:26:15   
	     */   
	    
	@Test
	public void testFindAll() {
		List<Returnsituation> returnsituations;
		returnsituations=returnSituationSevice.findAll();
		assertNotNull(returnsituations);
	}

}
