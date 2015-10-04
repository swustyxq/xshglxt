package StuMtrManageSys.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.TestService.DetailServiceTest;
import StuMtrManageSys.dao.DetailMapper;
import StuMtrManageSys.dao.MaterialMapper;
import StuMtrManageSys.dao.ReturnsituationMapper;
import StuMtrManageSys.model.Detail;
import StuMtrManageSys.model.DetailWithBLOBs;
import StuMtrManageSys.model.Material;
import StuMtrManageSys.model.Returnsituation;
import StuMtrManageSys.selfmodel.BorrowAndReturnList;
import StuMtrManageSys.selfmodel.BorrowRecordList;
import StuMtrManageSys.selfmodel.ReturnMtrList;
import StuMtrManageSys.service.DetailService;

/**
 * . 类名： DetailServiceImpl 描述： 借还记录细节服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:14:16
 */

@Service("detailService")
public class DetailServiceImpl implements DetailService {

	private DetailMapper detailMapper;
	private ReturnsituationMapper returnsituationMapper;
	private MaterialMapper materialMapper;

	public MaterialMapper getMaterialMapper() {
		return materialMapper;
	}

	@Autowired
	public void setMaterialMapper(MaterialMapper materialMapper) {
		this.materialMapper = materialMapper;
	}

	public ReturnsituationMapper getReturnsituationMapper() {
		return returnsituationMapper;
	}

	@Autowired
	public void setReturnsituationMapper(
			ReturnsituationMapper returnsituationMapper) {
		this.returnsituationMapper = returnsituationMapper;
	}

	public DetailMapper getDetailMapper() {
		return detailMapper;
	}

	@Autowired
	public void setDetailMapper(DetailMapper detailMapper) {
		this.detailMapper = detailMapper;
	}

	/*
	 * (non-Javadoc) Title: InsertDetial Description: 插入借还记录明细
	 * 
	 * @param detail 明细对象
	 * 
	 * @return int类型变量
	 * 
	 * @see
	 * StuMtrManageSys.service.DetailService#InsertDetial(StuMtrManageSys.model
	 * .DetailWithBLOBs)
	 */
	@SuppressWarnings("finally")
	public int insertDetial(DetailWithBLOBs detail) {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			detailMapper.insert(detail);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
			flag = 0;
		} finally {
			return flag;
		}
	}

	/*
	 * (non-Javadoc) Title: SelectDetail Description: 按照借还记录查询明细
	 * 
	 * @param recordId 借还记录ID
	 * 
	 * @return 明细list对象
	 * 
	 * @see
	 * StuMtrManageSys.service.DetailService#SelectDetail(java.lang.Integer)
	 */
	@SuppressWarnings("finally")
	public List<DetailWithBLOBs> selectDetail(Integer recordId) {
		// TODO Auto-generated method stub
		List<DetailWithBLOBs> details = null;

		try {
			details = detailMapper.selectByRecordId(recordId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return details;
		}

	}

	/*
	 * (non-Javadoc) Title: addDetial Description: 增加借还明细
	 * 
	 * @param detailRecordid 记录ID
	 * 
	 * @param detailMtrid 物资ID
	 * 
	 * @param detailMtrnum 申请物资数量
	 * 
	 * @param mtrPostil 备注
	 * 
	 * @return int类型变量
	 * 
	 * @see StuMtrManageSys.service.DetailService#addDetial(int, int, int,
	 * java.lang.String)
	 */
	@SuppressWarnings("finally")
	public int addDetial(int detailRecordid, int detailMtrid, int detailMtrnum,
			String mtrPostil) {
		DetailWithBLOBs detail = new DetailWithBLOBs();
		int flag = 0;
		try {
			detail.setDetailRecordid(detailRecordid);
			detail.setDetailMtrid(detailMtrid);
			detail.setDetailMtrnum(detailMtrnum);
			detail.setDetailPostil(mtrPostil);
			detail.setDetailInspstate(0);
			detail.setDetailReturnstate(0);

			detailMapper.insertSelective(detail);

			// 更新物资数量，减去申请的数量
			Material material = materialMapper.selectByPrimaryKey(detailMtrid);
			material.setMtrStocknum(material.getMtrStocknum() - detailMtrnum);
			materialMapper.updateByPrimaryKeySelective(material);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
			flag = 0;
		} finally {
			return flag;
		}
	}

	/*
	 * (non-Javadoc) Title: findAllDetail Description: 查找所有明细
	 * 
	 * @return 返回所有明细list
	 * 
	 * @see StuMtrManageSys.service.DetailService#findAllDetail()
	 */
	public List<BorrowRecordList> findAllDetail() {
		List<BorrowRecordList> borrowRecordLists = null;
		try {
			borrowRecordLists = detailMapper.selectAllDetail();
		} catch (Exception e) {
			System.out.println(e);
		}
		return borrowRecordLists;
	}

	/*
	 * (non-Javadoc) Title: deleteDetail 删除明细 Description:
	 * 
	 * @param detailId 明细Id
	 * 
	 * @return bool类型变量
	 * 
	 * @see StuMtrManageSys.service.DetailService#deleteDetail(int)
	 */
	public boolean deleteDetail(int detailId) {
		try {
			detailMapper.deleteByPrimaryKey(detailId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc) Title: checkDetail Description: 审核物资
	 * 
	 * @param detailId 明细Id
	 * 
	 * @param result 同意还是拒绝
	 * 
	 * @param rejectReason 拒绝原因
	 * 
	 * @param userId 用户id
	 * 
	 * @return int类型变量
	 * 
	 * @see StuMtrManageSys.service.DetailService#checkDetail(int, boolean,
	 * java.lang.String, java.lang.Integer)
	 */
	@SuppressWarnings("finally")
	public int checkDetail(int detailId, boolean result, String rejectReason,
			Integer userId) {
		int flag = 0;
		try {
			DetailWithBLOBs detail = new DetailWithBLOBs();
			detail.setDetailId(detailId);
			detail.setDetailInspector(userId);
			if (true == result) {
				detail.setDetailInspstate(1);
			} else {
				detail.setDetailInspstate(2);
				detail.setDetailRejectreason(rejectReason);
			}
			// 获取当前系统时间
			Date detailInsptime = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(detailInsptime);
			detail.setDetailInsptime(detailInsptime);

			detailMapper.updateByPrimaryKeySelective(detail);

			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
			flag = 0;
		} finally {
			return flag;
		}
	}

	/*
	 * (non-Javadoc) Title: updateDetail Description: 更新借还明细
	 * 
	 * @param detail 明细变量
	 * 
	 * @return bool类型变量
	 * 
	 * @see
	 * StuMtrManageSys.service.DetailService#updateDetail(StuMtrManageSys.model
	 * .DetailWithBLOBs)
	 */
	@Override
	public boolean updateDetail(DetailWithBLOBs detail) {
		try {
			detailMapper.updateByPrimaryKeySelective(detail);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc) Title: updateReturnSituation Description: 更新归还情况
	 * 
	 * @param returnsituation 归还 情况变量
	 * 
	 * @return bool类型变量
	 * 
	 * @see
	 * StuMtrManageSys.service.DetailService#updateReturnSituation(StuMtrManageSys
	 * .model.Returnsituation)
	 */
	@Override
	public boolean updateReturnSituation(Returnsituation returnsituation) {
		try {
			returnsituationMapper.updateByPrimaryKeyWithBLOBs(returnsituation);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc) Title: findAllBaRRecords Description: 查找所有借还记录
	 * 
	 * @return 借还记录list
	 * 
	 * @see StuMtrManageSys.service.DetailService#findAllBaRRecords()
	 */
	@SuppressWarnings("finally")
	public List<BorrowAndReturnList> findAllBaRRecords() {
		List<BorrowAndReturnList> lists = null;
		try {
			lists = detailMapper.selectAllBorrowAndReturn();

			int recordIdTemp = -1;
			lists.get(0).recordPos = new ArrayList<Integer>();
			for (int i = 0; i < lists.size(); i++) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy年MM月dd日HH时mm分ss秒");
				String date = sdf.format(lists.get(i).getApplyTime());
				lists.get(i).setApplyTurnTime(date);
				if (lists.get(i).getDetailInsptime() != null) {
					date = sdf.format(lists.get(i).getDetailInsptime());
					lists.get(i).setTurnInsptime(date);
				}
				if (lists.get(i).getDetailReturntime() != null) {
					date = sdf.format(lists.get(i).getDetailReturntime());
					lists.get(i).setTurnReturntime(date);
				}
				if (recordIdTemp != lists.get(i).getRecordId()) {
					recordIdTemp = lists.get(i).getRecordId();
					lists.get(0).recordPos.add(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return lists;
		}
	}

	/*
	 * (non-Javadoc) Title: findAllReturnMtr Description: 查找所以归还物资
	 * 
	 * @return 归还物资list
	 * 
	 * @see StuMtrManageSys.service.DetailService#findAllReturnMtr()
	 */
	@SuppressWarnings("finally")
	public List<ReturnMtrList> findAllReturnMtr() {
		List<ReturnMtrList> returnMtrLists = null;
		try {
			returnMtrLists = detailMapper.selectAllReturnMtr();
			for (int i = 0; i < returnMtrLists.size(); i++) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy年MM月dd日HH时mm分ss秒");
				String date = sdf.format(returnMtrLists.get(i).getApplyTime());
				returnMtrLists.get(i).setApplyTurnTime(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnMtrLists;
		}
	}

	/*
	 * (non-Javadoc) Title: updateDetailReturn Description: 更新归还记录明细
	 * 
	 * @param detailId 明细ID
	 * 
	 * @param situation 归还情况ID
	 * 
	 * @see StuMtrManageSys.service.DetailService#updateDetailReturn(int, int)
	 */
	@SuppressWarnings("finally")
	public void updateDetailReturn(int detailId, int situation) {
		try {
			DetailWithBLOBs detail = new DetailWithBLOBs();
			detail.setDetailId(detailId);
			detail.setDetailReturnstate(1);
			detail.setDetailReturnsituation(situation);
			// 获取当前系统时间
			Date detailInsptime = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(detailInsptime);
			detail.setDetailReturntime(detailInsptime);
			detailMapper.updateByPrimaryKeySelective(detail);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return;
		}

	}

}
