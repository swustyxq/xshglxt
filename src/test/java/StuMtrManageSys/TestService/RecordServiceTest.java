package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.Record;
import StuMtrManageSys.selfmodel.MtrRecordList;
import StuMtrManageSys.service.RecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class RecordServiceTest {
	  
	/**  . 
	 * 变量  recordService:TODO 
	 */   
	    
	private RecordService recordService;

	public RecordService getRecordService() {
		return recordService;
	}

	@Autowired
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}

	  
	/**  . 
	 * 方法名：  testAddOneRecord
	 * 此方法描述的是：  增加记录 
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:59:39   
	 */   
	    
	@Test
	public void testAddOneRecord() {
		int id=recordService.addOneRecord(1);
		assertNotEquals(id, 0);
	}

	  

	  
	/** .  
	 * 方法名：  testSelectRecord
	 * 此方法描述的是：   查询记录
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:59:26   
	 */   
	    
	@Test
	public void testSelectRecord() {
		List<Record> records=recordService.selectRecord(1);
		assertNotNull(records);
	}

	  
	/**  . 
	 * 方法名：  testFindAllCheckMsg
	 * 此方法描述的是：   
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:59:29   
	 */   
	    
	@Test
	public void testFindAllCheckMsg() {
		List<MtrRecordList> records=recordService.findAllCheckMsg();
		assertNotNull(records);
	}

}
