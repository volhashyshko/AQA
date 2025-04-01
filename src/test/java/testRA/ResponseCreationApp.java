package testRA;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCreationApp {
    public int applicantid;
    public int citizenid;
    public int applicationid;
    public int merrigecertificateid;
    public Object data;

    @JsonCreator
    public ResponseCreationApp(
            @JsonProperty("applicantid") int applicantId,
            @JsonProperty("citizenid") int citizenId,
            @JsonProperty("applicationid") int applicationId,
            @JsonProperty("marriagecertificateid") int marriagecertificateid,
            @JsonProperty("data") Object data) {

        this.applicantid = applicantId;
        this.citizenid = citizenId;
        this.applicationid = applicationId;
        this.merrigecertificateid = marriagecertificateid;
        this.data = data; // Инициализация поля data
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

