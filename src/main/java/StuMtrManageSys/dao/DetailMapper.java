package StuMtrManageSys.dao;

import java.util.List;

import StuMtrManageSys.model.Detail;
import StuMtrManageSys.model.DetailWithBLOBs;
import StuMtrManageSys.selfmodel.BorrowAndReturnList;
import StuMtrManageSys.selfmodel.BorrowRecordList;
import StuMtrManageSys.selfmodel.ReturnMtrList;

public interface DetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(DetailWithBLOBs record);

    int insertSelective(DetailWithBLOBs record);

    DetailWithBLOBs selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(DetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DetailWithBLOBs record);

    int updateByPrimaryKey(Detail record);

    // 根据记录id查询细节
    List<DetailWithBLOBs> selectByRecordId(Integer recordId);
    List<BorrowRecordList> selectAllDetail();

	List<BorrowAndReturnList> selectAllBorrowAndReturn();

	List<ReturnMtrList> selectAllReturnMtr();
}