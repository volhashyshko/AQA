package testRA;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCreationApp {
    public Integer applicantid;
    public Integer citizenid;
    public Integer applicationid;
    public Integer merrigecertificateid;

    @JsonCreator
    public ResponseCreationApp(
            @JsonProperty("applicantid") Integer applicantId,
            @JsonProperty("citizenid") Integer citizenId,
            @JsonProperty("applicationid") Integer applicationId,
            @JsonProperty("marriagecertificateid") Integer marriagecertificateid) {

        this.applicantid = applicantId; // Инициализация полей
        this.citizenid = citizenId;
        this.applicationid = applicationId;
        this.merrigecertificateid = marriagecertificateid;
    }

    public Integer getApplicantid() {
        return applicantid;
    }
    public void setApplicantid(Integer applicantid) {
        this.applicantid = applicantid;
    }
    public Integer getCitizenid() {
        return citizenid;
    }
    public void setCitizenid(Integer citizenid) {
        this.citizenid = citizenid;
    }
    public Integer getApplicationid() {
        return applicationid;
    }
    public void setApplicationid(Integer applicationid) {
        this.applicationid = applicationid;
    }
    public Integer getMerrigecertificateid() {
        return merrigecertificateid;
    }
    public void setMerrigecertificateid(Integer merrigecertificateid) {
        this.merrigecertificateid = merrigecertificateid;
    }
}

