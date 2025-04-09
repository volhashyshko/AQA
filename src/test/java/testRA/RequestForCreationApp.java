package testRA;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record RequestForCreationApp (
    String mode,
    String personalLastName,
    String personalFirstName,
    String personalMiddleName,
    String personalPhoneNumber,
    String personalNumberOfPassport,
    String citizenLastName,
    String citizenFirstName,
    String citizenMiddleName,
    String citizenBirthDate,
    String citizenNumberOfPassport,
    String citizenGender,
    String dateOfMarriage,
    String newLastName,
    String anotherPersonLastName,
    String anotherPersonFirstName,
    String anotherPersonMiddleName,
    String birth_of_anotoherPerson,
    String anotherPersonPassport,
    String birth_father,
    String birth_grandma,
    String birth_grandpa,
    String birth_mother,
    String birth_place,
    String citizenAddress,
    String death_dateOfDeath,
    String death_placeOfDeath,
    String personalAddress) {

}



