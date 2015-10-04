package StuMtrManageSys.model;

import java.util.Date;

public class Detail {
    private Integer detailId;

    private Integer detailRecordid;

    private Integer detailMtrid;

    private Integer detailMtrnum;

    private Integer detailInspstate;

    private Integer detailInspector;

    private Date detailInsptime;

    private Integer detailReturnstate;

    private Date detailReturntime;

    private Integer detailReturnsituation;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailRecordid() {
        return detailRecordid;
    }

    public void setDetailRecordid(Integer detailRecordid) {
        this.detailRecordid = detailRecordid;
    }

    public Integer getDetailMtrid() {
        return detailMtrid;
    }

    public void setDetailMtrid(Integer detailMtrid) {
        this.detailMtrid = detailMtrid;
    }

    public Integer getDetailMtrnum() {
        return detailMtrnum;
    }

    public void setDetailMtrnum(Integer detailMtrnum) {
        this.detailMtrnum = detailMtrnum;
    }

    public Integer getDetailInspstate() {
        return detailInspstate;
    }

    public void setDetailInspstate(Integer detailInspstate) {
        this.detailInspstate = detailInspstate;
    }

    public Integer getDetailInspector() {
        return detailInspector;
    }

    public void setDetailInspector(Integer detailInspector) {
        this.detailInspector = detailInspector;
    }

    public Date getDetailInsptime() {
        return detailInsptime;
    }

    public void setDetailInsptime(Date detailInsptime) {
        this.detailInsptime = detailInsptime;
    }

    public Integer getDetailReturnstate() {
        return detailReturnstate;
    }

    public void setDetailReturnstate(Integer detailReturnstate) {
        this.detailReturnstate = detailReturnstate;
    }

    public Date getDetailReturntime() {
        return detailReturntime;
    }

    public void setDetailReturntime(Date detailReturntime) {
        this.detailReturntime = detailReturntime;
    }

    public Integer getDetailReturnsituation() {
        return detailReturnsituation;
    }

    public void setDetailReturnsituation(Integer detailReturnsituation) {
        this.detailReturnsituation = detailReturnsituation;
    }
}