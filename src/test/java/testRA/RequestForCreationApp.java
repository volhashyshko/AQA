package testRA;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestForCreationApp {
    public String mode;
    public String personalLastName;
    public String personalFirstName;
    public String personalMiddleName;
    public String personalPhoneNumber;
    public String personalNumberOfPassport;
    public String citizenLastName;
    public String citizenFirstName;
    public String citizenMiddleName;
    public String citizenBirthDate;
    public String citizenNumberOfPassport;
    public String citizenGender;
    public String dateOfMarriage;
    public String newLastName;
    public String anotherPersonLastName;
    public String anotherPersonFirstName;
    public String anotherPersonMiddleName;
    public String birth_of_anotoherPerson;
    public String anotherPersonPassport;
    public String birth_father;
    public String birth_grandma;
    public String birth_grandpa;
    public String birth_mother;
    public String birth_place;
    public String citizenAddress;
    public String death_dateOfDeath;
    public String death_placeOfDeath;
    public String personalAddress;

    @JsonCreator
    public RequestForCreationApp(
            @JsonProperty("mode") String mode,
            @JsonProperty("personalLastName") String personalLastName,
            @JsonProperty("personalFirstName") String personalFirstName,
            @JsonProperty("personalMiddleName") String personalMiddleName,
            @JsonProperty("personalPhoneNumber") String personalPhoneNumber,
            @JsonProperty("personalNumberOfPassport") String personalNumberOfPassport,
            @JsonProperty("citizenLastName") String citizenLastName,
            @JsonProperty("citizenFirstName") String citizenFirstName,
            @JsonProperty("citizenMiddleName") String citizenMiddleName,
            @JsonProperty("citizenBirthDate") String citizenBirthDate,
            @JsonProperty("citizenNumberOfPassport") String citizenNumberOfPassport,
            @JsonProperty("citizenGender") String citizenGender,
            @JsonProperty("dateOfMarriage") String dateOfMarriage,
            @JsonProperty("newLastName") String newLastName,
            @JsonProperty("anotherPersonLastName") String anotherPersonLastName,
            @JsonProperty("anotherPersonFirstName") String anotherPersonFirstName,
            @JsonProperty("anotherPersonMiddleName") String anotherPersonMiddleName,
            @JsonProperty("birth_of_anotoherPerson") String birth_of_anotoherPerson,
            @JsonProperty("anotherPersonPassport") String anotherPersonPassport,
            @JsonProperty("birth_father") String birth_father,
            @JsonProperty("birth_grandma") String birth_grandma,
            @JsonProperty("birth_grandpa") String birth_grandpa,
            @JsonProperty("birth_mother") String birth_mother,
            @JsonProperty("birth_place") String birth_place,
            @JsonProperty("citizenAddress") String citizenAddress,
            @JsonProperty("death_dateOfDeath") String death_dateOfDeath,
            @JsonProperty("death_placeOfDeath") String death_placeOfDeath,
            @JsonProperty("personalAddress") String personalAddress) {

        this.mode = mode; //Инициализация полей
        this.personalLastName = personalLastName;
        this.personalFirstName = personalFirstName;
        this.personalMiddleName = personalMiddleName;
        this.personalPhoneNumber = personalPhoneNumber;
        this.personalNumberOfPassport = personalNumberOfPassport;
        this.citizenLastName = citizenLastName;
        this.citizenFirstName = citizenFirstName;
        this.citizenMiddleName = citizenMiddleName;
        this.citizenBirthDate = citizenBirthDate;
        this.citizenNumberOfPassport = citizenNumberOfPassport;
        this.citizenGender = citizenGender;
        this.dateOfMarriage = dateOfMarriage;
        this.newLastName = newLastName;
        this.anotherPersonLastName = anotherPersonLastName;
        this.anotherPersonFirstName = anotherPersonFirstName;
        this.anotherPersonMiddleName = anotherPersonMiddleName;
        this.birth_of_anotoherPerson = birth_of_anotoherPerson;
        this.anotherPersonPassport = anotherPersonPassport;
        this.birth_father = birth_father;
        this.birth_grandma = birth_grandma;
        this.birth_grandpa = birth_grandpa;
        this.birth_mother = birth_mother;
        this.birth_place = birth_place;
        this.citizenAddress = citizenAddress;
        this.death_dateOfDeath = death_dateOfDeath;
        this.death_placeOfDeath = death_placeOfDeath;
        this.personalAddress = personalAddress;
    }

    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getPersonalLastName() {
        return personalLastName;
    }
    public void setPersonalLastName(String personalLastName) {
        this.personalLastName = personalLastName;
    }
    public String getPersonalFirstName() {
        return personalFirstName;
    }
    public void setPersonalFirstName(String personalFirstName) {
        this.personalFirstName = personalFirstName;
    }
    public String getPersonalMiddleName() {
        return personalMiddleName;
    }
    public void setPersonalMiddleName(String personalMiddleName) {
        this.personalMiddleName = personalMiddleName;
    }
    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }
    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }
    public String getPersonalNumberOfPassport() {
        return personalNumberOfPassport;
    }
    public void setPersonalNumberOfPassport(String personalNumberOfPassport) {
        this.personalNumberOfPassport = personalNumberOfPassport;
    }
    public String getCitizenLastName() {
        return citizenLastName;
    }
    public void setCitizenLastName(String citizenLastName) {
        this.citizenLastName = citizenLastName;
    }
    public String getCitizenFirstName() {
        return citizenFirstName;
    }
    public void setCitizenFirstName(String citizenFirstName) {
        this.citizenFirstName = citizenFirstName;
    }
    public String getCitizenMiddleName() {
        return citizenMiddleName;
    }
    public void setCitizenMiddleName(String citizenMiddleName) {
        this.citizenMiddleName = citizenMiddleName;
    }
    public String getCitizenBirthDate() {
        return citizenBirthDate;
    }
    public void setCitizenBirthDate(String citizenBirthDate) {
        this.citizenBirthDate = citizenBirthDate;
    }
    public String getCitizenNumberOfPassport() {
        return citizenNumberOfPassport;
    }
    public void setCitizenNumberOfPassport(String citizenNumberOfPassport) {
        this.citizenNumberOfPassport = citizenNumberOfPassport;
    }
    public String getCitizenGender() {
        return citizenGender;
    }
    public void setCitizenGender(String citizenGender) {
        this.citizenGender = citizenGender;
    }
    public String getDateOfMarriage() {
        return dateOfMarriage;
    }
    public void setDateOfMarriage(String dateOfMarriage) {
        this.dateOfMarriage = dateOfMarriage;
    }
    public String getNewLastName() {
        return newLastName;
    }
    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }
    public String getAnotherPersonLastName() {
        return anotherPersonLastName;
    }
    public void setAnotherPersonLastName(String anotherPersonLastName) {
        this.anotherPersonLastName = anotherPersonLastName;
    }
    public String getAnotherPersonFirstName() {
        return anotherPersonFirstName;
    }
    public void setAnotherPersonFirstName(String anotherPersonFirstName) {
        this.anotherPersonFirstName = anotherPersonFirstName;
    }
    public String getAnotherPersonMiddleName() {
        return anotherPersonMiddleName;
    }
    public void setAnotherPersonMiddleName(String anotherPersonMiddleName) {
        this.anotherPersonMiddleName = anotherPersonMiddleName;
    }
    public String getBirth_of_anotoherPerson() {
        return birth_of_anotoherPerson;
    }
    public void setBirth_of_anotoherPerson(String birth_of_anotoherPerson) {
        this.birth_of_anotoherPerson = birth_of_anotoherPerson;
    }
    public String getAnotherPersonPassport() {
        return anotherPersonPassport;
    }
    public void setAnotherPersonPassport(String anotherPersonPassport) {
        this.anotherPersonPassport = anotherPersonPassport;
    }
    public String getBirth_father() {
        return birth_father;
    }
    public void setBirth_father(String birth_father) {
        this.birth_father = birth_father;
    }
    public String getBirth_grandma() {
        return birth_grandma;
    }
    public void setBirth_grandma(String birth_grandma) {
        this.birth_grandma = birth_grandma;
    }
    public String getBirth_grandpa() {
        return birth_grandpa;
    }
    public void setBirth_grandpa(String birth_grandpa) {
        this.birth_grandpa = birth_grandpa;
    }
    public String getBirth_mother() {
        return birth_mother;
    }
    public void setBirth_mother(String birth_mother) {
        this.birth_mother = birth_mother;
    }
    public String getBirth_place() {
        return birth_place;
    }
    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }
    public String getCitizenAddress() {
        return citizenAddress;
    }
    public void setCitizenAddress(String citizenAddress) {
        this.citizenAddress = citizenAddress;
    }
    public String getDeath_dateOfDeath() {
        return death_dateOfDeath;
    }
    public void setDeath_dateOfDeath(String death_dateOfDeath) {
        this.death_dateOfDeath = death_dateOfDeath;
    }
    public String getDeath_placeOfDeath() {
        return death_placeOfDeath;
    }
    public void setDeath_placeOfDeath(String death_placeOfDeath) {
        this.death_placeOfDeath = death_placeOfDeath;
    }
    public String getPersonalAddress() {
        return personalAddress;
    }
    public void setPersonalAddress(String personalAddress) {
        this.personalAddress = personalAddress;
    }
}



