package StuMtrManageSys.model;

public class DetailWithBLOBs extends Detail {
    private String detailPostil;

    private String detailRejectreason;

    private String detailApplyreason;

    public String getDetailPostil() {
        return detailPostil;
    }

    public void setDetailPostil(String detailPostil) {
        this.detailPostil = detailPostil;
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
}