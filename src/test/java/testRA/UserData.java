package testRA;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class UserData {

    private final Integer applicationid;
    private final Integer citizenid;
    private final Integer applicantid;
    private final Integer staffid;
    private final Date dateofapplication;
    private final String kindofapplication;
    private final String statusofapplication;
    private final String channel;
    private final Object image;

    @JsonCreator
    public UserData(
            @JsonProperty("applicationid") Integer applicationid,
            @JsonProperty("citizenid") Integer citizenid,
            @JsonProperty("applicantid") Integer applicantid,
            @JsonProperty("staffid") Integer staffid,
            @JsonProperty("dateofapplication") Date dateofapplication,
            @JsonProperty("kindofapplication") String kindofapplication,
            @JsonProperty("statusofapplication") String statusofapplication,
            @JsonProperty("channel") String channel,
            @JsonProperty("image") Object image) {

        this.applicationid = applicationid; // Инициализация полей
        this.citizenid = citizenid;
        this.applicantid = applicantid;
        this.staffid = staffid;
        this.dateofapplication = dateofapplication;
        this.kindofapplication = kindofapplication;
        this.statusofapplication = statusofapplication;
        this.channel = channel;
        this.image = image;
    }

    public Integer getApplicationid() {
        return applicationid;
    }
    public Integer getCitizenid() {
        return citizenid;
    }
    public Integer getApplicantid() {
        return applicantid;
    }
    public Integer getStaffid() {
        return staffid;
    }
    public Date getDateofapplication() {
        return dateofapplication;
    }
    public String getKindofapplication() {
        return kindofapplication;
    }
    public String getStatusofapplication() {
        return statusofapplication;
    }
    public String getChannel() {
        return channel;
    }
    public Object getImage() {
        return image;
    }
}
