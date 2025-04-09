package testRA;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseCreationApp (
    AppItem data,
    String requestId) {

    public record AppItem(
            Integer applicantid,
            Integer citizenid,
            Integer applicationid,
            Integer merrigecertificateid) {
    }
}

