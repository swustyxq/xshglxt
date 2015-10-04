package StuMtrManageSys.dao;

import java.util.List;

import StuMtrManageSys.model.Record;
import StuMtrManageSys.selfmodel.MtrRecordList;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    // 查找插入语句的ID
    Record selectLastInsertId(Record record);

    // 按用户id查询记录
    List<Record> selectByUserId(Integer userId);

    //查找所用需要审核的记录及记录下的物资
    List<MtrRecordList> selectAllCheckInfo();
}