package StuMtrManageSys.selfmodel;

import java.sql.Date;
import java.util.List;


public class BorrowAndReturnList{
		private int recordId;
		private String  applyerName;
		private String applerDept;
		private Date applyTime;
		private int applyerId;
		private String mtrInfo;
		private String inspectorName;
		private String returnName;
		private String applyTurnTime="";//由时间戳转化而来
		public List<Integer> recordPos;//存放有效记录的位置 
		private String detailRejectreason;
		private String detailApplyreason;
		private Integer detailId;
	    private Integer detailMtrnum;
	    private Integer detailInspstate;
	    private Date detailInsptime;
	    private Integer detailReturnstate;
	    private Date detailReturntime;
	    private Integer detailReturnsituation;
	    private String turnInsptime;//审核时间
	    private String turnReturntime;//归还时间
		
		public List<Integer> getRecordPos() {
			return recordPos;
		}
		public void setRecordPos(List<Integer> recordPos) {
			this.recordPos = recordPos;
		}
		public String getDetailRejectreason() {
			return detailRejectreason;
		}
		public void setDetailRejectreason(String detailRejectreason) {
			this.detailRejectreason = detailRejectreason;
		}
		public String getDetailApplyreason() {
			return detailApplyreason;
		}
		public void setDetailApplyreason(String detailApplyreason) {
			this.detailApplyreason = detailApplyreason;
		}
		public Integer getDetailId() {
			return detailId;
		}
		public void setDetailId(Integer detailId) {
			this.detailId = detailId;
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
		public String getTurnInsptime() {
			return turnInsptime;
		}
		public void setTurnInsptime(String turnInsptime) {
			this.turnInsptime = turnInsptime;
		}
		public String getTurnReturntime() {
			return turnReturntime;
		}
		public void setTurnReturntime(String turnReturntime) {
			this.turnReturntime = turnReturntime;
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
		public Date getApplyTime() {
			return applyTime;
		}
		public void setApplyTime(Date applyTime) {
			this.applyTime = applyTime;
		}
		public int getApplyerId() {
			return applyerId;
		}
		public void setApplyerId(int applyerId) {
			this.applyerId = applyerId;
		}
		public String getMtrInfo() {
			return mtrInfo;
		}
		public void setMtrInfo(String mtrInfo) {
			this.mtrInfo = mtrInfo;
		}
		public String getInspectorName() {
			return inspectorName;
		}
		public void setInspectorName(String inspectorName) {
			this.inspectorName = inspectorName;
		}
		public String getReturnName() {
			return returnName;
		}
		public void setReturnName(String returnName) {
			this.returnName = returnName;
		}
}
