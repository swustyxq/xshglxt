package StuMtrManageSys.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StuMtrManageSys.dao.RecordMapper;
import StuMtrManageSys.model.Record;
import StuMtrManageSys.selfmodel.MtrRecordList;
import StuMtrManageSys.service.RecordService;

  
/**   .
 * 类名：  RecordServiceImpl 
 * 描述：  记录服务
 * 
 * @author: 同路人小组
 * @version: 2015年1月16日 上午3:53:38    
 */   
    
@Service("recordService")
public class RecordServiceImpl implements RecordService {

    private RecordMapper recordMapper;

    public RecordMapper getRecordMapper() {
        return recordMapper;
    }

    @Autowired
    public void setRecordMapper(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

      
    /* (non-Javadoc)   
     * Title: addOneRecord
     * Description:新增一条记录
     * @param applyerId审核人主键
     * @return记录主键
     * @see StuMtrManageSys.service.RecordService#addOneRecord(int)
     */  
    @SuppressWarnings("finally")
    public int addOneRecord(int applyerId) {
        Record record = new Record();
        int id = 0;
        try {
            record.setRecordApplyerid(applyerId);
         // 获取当前系统时间
            Date recordBorrowtime = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(recordBorrowtime);
            record.setRecordBorrowtime(recordBorrowtime);
            
            recordMapper.insert(record);
            record = recordMapper.selectLastInsertId(record);
            id = record.getRecordId();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }



      
    /* (non-Javadoc)   
     * Title: SelectRecord
     * Description:通过用户主键查找记录
     * @param userId用户主键
     * @return记录列表
     * @see StuMtrManageSys.service.RecordService#SelectRecord(java.lang.Integer)
     */  
    @SuppressWarnings("finally")
    public List<Record> selectRecord(Integer userId) {
        // TODO Auto-generated method stub

        List<Record> records = null;

        try {
            records = recordMapper.selectByUserId(userId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return records;
        }

    }

      
    /* (non-Javadoc)   
     * Title: findAllCheckMsg
     * Description:查找全部记录
     * @return记录列表
     * @see StuMtrManageSys.service.RecordService#findAllCheckMsg()
     */  
    @SuppressWarnings("finally")
    public List<MtrRecordList> findAllCheckMsg() {
        List<MtrRecordList> mtrRecordLists=null;
        try {
            mtrRecordLists = recordMapper.selectAllCheckInfo();
            int recordIdTemp = -1;
            int recordCount = 0;
            mtrRecordLists.get(0).recordPos = new ArrayList<Integer>();
            for (int i = 0;i < mtrRecordLists.size();i++){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
                String date = sdf.format(mtrRecordLists.get(i).getApplyTime());
                mtrRecordLists.get(i).setApplyTurnTime(date);
                if (recordIdTemp != mtrRecordLists.get(i).getRecordId()){
                    recordCount++;
                    recordIdTemp = mtrRecordLists.get(i).getRecordId();
                    mtrRecordLists.get(0).recordPos.add(i);
                }
            }
            mtrRecordLists.get(0).setRecordCount(recordCount);
            
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            return mtrRecordLists;
        }
    }


}
