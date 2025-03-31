package testRA;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class UserData {

    private final int applicationid;
    private final int citizenid;
    private final int applicantid;
    private final int staffid;
    private final Date dateofapplication;
    private final String kindofapplication;
    private final String statusofapplication;
    private final String channel;
    private final Object image;

    @JsonCreator
    public UserData(
            @JsonProperty("applicationid") int applicationid,
            @JsonProperty("citizenid") int citizenid,
            @JsonProperty("applicantid") int applicantid,
            @JsonProperty("staffid") int staffid,
            @JsonProperty("dateofapplication") Date dateofapplication,
            @JsonProperty("kindofapplication") String kindofapplication,
            @JsonProperty("statusofapplication") String statusofapplication,
            @JsonProperty("channel") String channel,
            @JsonProperty("image") Object image) {

        this.applicationid = applicationid;
        this.citizenid = citizenid;
        this.applicantid = applicantid;
        this.staffid = staffid;
        this.dateofapplication = dateofapplication;
        this.kindofapplication = kindofapplication;
        this.statusofapplication = statusofapplication;
        this.channel = channel;
        this.image = image;
    }

    public int getApplicationid() {
        return applicationid;
    }

    public int getCitizenid() {
        return citizenid;
    }

    public int getApplicantid() {
        return applicantid;
    }

    public int getStaffid() {
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
