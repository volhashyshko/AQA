package testRA;

public class ResponseCreationApp {
    public int applicantid;
    public int citizenid;
    public int applicationid;
    public int merrigecertificateid;

    public ResponseCreationApp(int applicantid, int citizenid, int applicationid, int merrigecertificateid) {
        this.applicantid = applicantid;
        this.citizenid = citizenid;
        this.applicationid = applicationid;
        this.merrigecertificateid = merrigecertificateid;
    }

    public int getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(int applicantid) {
        this.applicantid = applicantid;
    }

    public int getCitizenid() {
        return citizenid;
    }

    public void setCitizenid(int citizenid) {
        this.citizenid = citizenid;
    }

    public int getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(int applicationid) {
        this.applicationid = applicationid;
    }

    public int getMerrigecertificateid() {
        return merrigecertificateid;
    }

    public void setMerrigecertificateid(int merrigecertificateid) {
        this.merrigecertificateid = merrigecertificateid;
    }
}
