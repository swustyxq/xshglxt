package StuMtrManageSys.model;

import java.util.Date;

public class Record {
    private Integer recordId;

    private Integer recordApplyerid;

    private Date recordBorrowtime;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRecordApplyerid() {
        return recordApplyerid;
    }

    public void setRecordApplyerid(Integer recordApplyerid) {
        this.recordApplyerid = recordApplyerid;
    }

    public Date getRecordBorrowtime() {
        return recordBorrowtime;
    }

    public void setRecordBorrowtime(Date recordBorrowtime) {
        this.recordBorrowtime = recordBorrowtime;
    }
}