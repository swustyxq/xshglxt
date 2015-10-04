package StuMtrManageSys.TestService;

import static org.junit.Assert.*;

import java.awt.image.RescaleOp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import StuMtrManageSys.model.DetailWithBLOBs;
import StuMtrManageSys.model.Returnsituation;
import StuMtrManageSys.selfmodel.BorrowAndReturnList;
import StuMtrManageSys.selfmodel.BorrowRecordList;
import StuMtrManageSys.selfmodel.ReturnMtrList;
import StuMtrManageSys.service.DepartmentSevice;
import StuMtrManageSys.service.DetailService;

/**.
 * 此类描述的是：测试借还记录明细服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月15日 下午11:23:31
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class DetailServiceTest {
	private DetailService detailService;

	
	/**.
	 * 此方法描述的是：获取明细服务变量
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:26
	 */
	public DetailService getDetailService() {
		return detailService;
	}

	/**.
	 * 此方法描述的是：设置明细服务变量
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:26
	 */

	@Autowired
	public void setDetailService(DetailService detailService) {
		this.detailService = detailService;
	}

	/**.
	 * 此方法描述的是：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:38
	 */

	@Test
	public void testInsertDetial() {
		DetailWithBLOBs detailWithBLOBs  = new DetailWithBLOBs();
		detailWithBLOBs.setDetailInspector(1);
		detailWithBLOBs.setDetailRecordid(15);
		detailWithBLOBs.setDetailMtrid(1);
		 // 获取当前系统时间
        Date recordBorrowtime = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(recordBorrowtime);
    
		detailWithBLOBs.setDetailInsptime(recordBorrowtime);
		
		assertEquals(1,detailService.insertDetial(detailWithBLOBs));
		
		}


	/**.
	 * 此方法描述的是：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:45
	 */

	@Test
	public void testSelectDetail() {
		List<DetailWithBLOBs> detailWithBLOBs  = detailService.selectDetail(1); 
		assertNotNull(detailWithBLOBs);
	}

	/**.
	 * 此方法描述的是：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:47
	 */

	@Test
	public void testAddDetial() {
		
		String noteString ="啊哈哈" ;
		assertEquals(1, detailService.addDetial(15, 1, 20,noteString)) ;
	}

	/**.
	 * 此方法描述的是：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:50
	 */

	@Test
	public void testFindAllDetail() {
		List<BorrowRecordList> borrowRecordLists =detailService.findAllDetail();
		assertNotNull(borrowRecordLists);
	}

	/**.
	 * 此方法描述的是：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:53
	 */

	@Test
	public void testDeleteDetail() {
		Boolean rs = detailService.deleteDetail(1) ;
		assertEquals(rs, true);
	}

	/**.
	 * 此方法描述的是：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:56
	 */

	@Test
	public void testCheckDetail() {
		
		assertEquals(1, detailService.checkDetail(1, true, "", 1));
	}

	/**.
	 * 此方法描述的是：
	 * 
	 * @author: 同路人小组
	 * @version: 2015年1月15日 下午11:23:59
	 */

	@Test
	public void testUpdateDetail() {
		DetailWithBLOBs detailWithBLOBs  = new DetailWithBLOBs();
		detailWithBLOBs.setDetailId(13);
		detailWithBLOBs.setDetailMtrid(1);
		
		assertEquals(true, detailService.updateDetail(detailWithBLOBs));
	}

	/** .  
	 * 方法名：  testUpdateReturnSituation
	 * 此方法描述的是：   
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:41:59   
	 */   
	    
	@Test
	public void testUpdateReturnSituation() {
		Returnsituation returnsituation  = new Returnsituation() ;
		returnsituation.setSituId(1);
		String notString = "延期" ;
		returnsituation.setSituDescription(notString);
		
		assertEquals(true, detailService.updateReturnSituation(returnsituation));
	}

	  
	/**  . 
	 * 方法名：  testFindAllBaRRecords
	 * 此方法描述的是：   
	 *  void：
	 * @author: 同路人小组 
	 * @version: 2015年1月16日 上午12:41:34   
	 */   
	    
	@Test
	public void testFindAllBaRRecords() {
		List<BorrowAndReturnList> borrowAndReturnLists = detailService.findAllBaRRecords();
		assertNotNull(borrowAndReturnLists);
	}
	@Test
	public void testfindAllReturnMtr() {
		List<ReturnMtrList> borrowAndReturnLists = detailService.findAllReturnMtr();
		assertNotNull(borrowAndReturnLists);
	}
}
