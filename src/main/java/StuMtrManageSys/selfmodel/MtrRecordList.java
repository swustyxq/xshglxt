package StuMtrManageSys.selfmodel;

import java.util.Date;
import java.util.List;

public class MtrRecordList {
    private int recordId;
    private int applyerId;
    private Date applyTime;
    private String applyerName;
    private String applerDept;//申请人所属部门
    private int inspState;//审核状态
    private int applyNum;//申请数量
    private String mtrInfo;//物资信息
    private int detailId;//详情Id
    private String applyTurnTime="";//由时间戳转化而来的时间
    private String applyReason="";//申请理由，由数据库中的备注字段得来
    private int recordCount=0;//有效记录总条数
    private int stockNum=0;//该物资的库存量
	public List<Integer> recordPos;//存放有效记录的位置
	private int mtrId;//申请的物资Id
	public int getMtrId() {
		return mtrId;
	}
	public void setMtrId(int mtrId) {
		this.mtrId = mtrId;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
    public int getRecordCount() {
        return recordCount;
    }
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
    public String getApplyReason() {
        return applyReason;
    }
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }
    public String getApplyTurnTime() {
        return applyTurnTime;
    }
    public void setApplyTurnTime(String applyTurnTime) {
        this.applyTurnTime = applyTurnTime;
    }
    public int getRecordId() {
        return recordId;
    }
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }
    public int getApplyerId() {
        return applyerId;
    }
    public void setApplyerId(int applyerId) {
        this.applyerId = applyerId;
    }
    public Date getApplyTime() {
        return applyTime;
    }
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
    public String getApplyerName() {
        return applyerName;
    }
    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }
    public String getApplerDept() {
        return applerDept;
    }
    public void setApplerDept(String applerDept) {
        this.applerDept = applerDept;
    }
    public int getInspState() {
        return inspState;
    }
    public void setInspState(int inspState) {
        this.inspState = inspState;
    }
    public int getApplyNum() {
        return applyNum;
    }
    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }
    public String getMtrInfo() {
        return mtrInfo;
    }
    public void setMtrInfo(String mtrInfo) {
        this.mtrInfo = mtrInfo;
    }
    public int getDetailId() {
        return detailId;
    }
    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }
}
