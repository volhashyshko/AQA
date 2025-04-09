package testRA;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserBody (
    UserData data,
    String requestId) {
    public record UserData (
        Integer applicationid,
        Integer citizenid,
        Integer applicantid,
        Integer staffid,
        Date dateofapplication,
        String kindofapplication,
        String statusofapplication,
        String channel,
        Object image) {
    }
}
