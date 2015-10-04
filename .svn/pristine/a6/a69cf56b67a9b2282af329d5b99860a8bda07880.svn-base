package StuMtrManageSys.service;

import java.util.List;

import StuMtrManageSys.model.DetailWithBLOBs;
import StuMtrManageSys.model.Returnsituation;
import StuMtrManageSys.selfmodel.BorrowAndReturnList;
import StuMtrManageSys.selfmodel.BorrowRecordList;
import StuMtrManageSys.selfmodel.ReturnMtrList;

public interface DetailService {

    public int insertDetial(DetailWithBLOBs detail);

    public List<DetailWithBLOBs> selectDetail(Integer recordId);

    public int addDetial(int detailRecordid, int detailMtrid, int detailMtrnum, String mtrPostil);
    
    List<BorrowRecordList> findAllDetail();

	public boolean deleteDetail(int detailId);

	public int checkDetail(int detailId, boolean result, String rejectReason,
			Integer userId);

	public boolean updateDetail(DetailWithBLOBs detail);
	
	public boolean updateReturnSituation(Returnsituation returnsituation);

	public List<BorrowAndReturnList> findAllBaRRecords();

	public List<ReturnMtrList> findAllReturnMtr();

	public void updateDetailReturn(int detailId, int situation);
}
