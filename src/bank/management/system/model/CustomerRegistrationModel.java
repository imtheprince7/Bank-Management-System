package bank.management.system.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class CustomerRegistrationModel implements Serializable {

    private String applicationNumber;
    private String userName;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String dob;
    private String gender;
    private String martialStatus;
    private String emailId;
    private String mobileNo;
    private String aadharcard;
    private String panCard;
    private String flateNo;
    private String street;
    private String landmark;
    private String pincode;
    private String district;
    private String city;
    private String state;
    private String country;
    private String accountNumber;
    private String ifscCode;
    private String micrCode;
    private String netbanking;
    private String mobileBanking;
    private String chequeBook;
    private String atmCard;
    private String encPassword;

    private String customerName;

    @Override
    public String toString() {
        return "CustomerForm{" + "applicationNumber=" + applicationNumber + ", userName=" + userName + ", firstName=" + firstName + ","
                + " lastName=" + lastName + ", fatherName=" + fatherName + ", motherName=" + motherName + ", dob=" + dob + ", gender=" + gender + ","
                + " martialStatus=" + martialStatus + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", aadharcard=" + aadharcard + ", "
                + "panCard=" + panCard + ", flateNo=" + flateNo + ", street=" + street + ", landmark=" + landmark + ", pincode=" + pincode + ","
                + " district=" + district + ", city=" + city + ", state=" + state + ", country=" + country + ", accountNumber=" + accountNumber + ","
                + " ifscCode=" + ifscCode + ", micrCode=" + micrCode + ", netbanking=" + netbanking + ", mobileBanking=" + mobileBanking + ", "
                + "chequeBook=" + chequeBook + ", atmCard=" + atmCard + '}';
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAadharcard() {
        return aadharcard;
    }

    public void setAadharcard(String aadharcard) {
        this.aadharcard = aadharcard;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getFlateNo() {
        return flateNo;
    }

    public void setFlateNo(String flateNo) {
        this.flateNo = flateNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getMicrCode() {
        return micrCode;
    }

    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    public String getNetbanking() {
        return netbanking;
    }

    public void setNetbanking(String netbanking) {
        this.netbanking = netbanking;
    }

    public String getMobileBanking() {
        return mobileBanking;
    }

    public void setMobileBanking(String mobileBanking) {
        this.mobileBanking = mobileBanking;
    }

    public String getChequeBook() {
        return chequeBook;
    }

    public void setChequeBook(String chequeBook) {
        this.chequeBook = chequeBook;
    }

    public String getAtmCard() {
        return atmCard;
    }

    public void setAtmCard(String atmCard) {
        this.atmCard = atmCard;
    }

    public String getEncPassword() {
        return encPassword;
    }

    public void setEncPassword(String encPassword) {
        this.encPassword = encPassword;
    }

    public String customerName() {
        return customerName;
    }

    public void customerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerRegistrationModel() {

    }

    public CustomerRegistrationModel(String applicationNumber, String userName, String firstName, String lastName, String fatherName,
            String motherName, String dob, String gender, String martialStatus, String emailId, String mobileNo, String aadharcard,
            String panCard, String flateNo, String street, String landmark, String pincode, String district, String city, String state,
            String country, String accountNumber, String ifscCode, String micrCode, String netbanking, String mobileBanking,
            String chequeBook, String atmCard) {
        this.applicationNumber = applicationNumber;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dob = dob;
        this.gender = gender;
        this.martialStatus = martialStatus;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.aadharcard = aadharcard;
        this.panCard = panCard;
        this.flateNo = flateNo;
        this.street = street;
        this.landmark = landmark;
        this.pincode = pincode;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.micrCode = micrCode;
        this.netbanking = netbanking;
        this.mobileBanking = mobileBanking;
        this.chequeBook = chequeBook;
        this.atmCard = atmCard;
    }

    public CustomerRegistrationModel(String customerName, String userName, String emailId, String mobileNo) {
        this.customerName = customerName;
        this.userName = userName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }

    public CustomerRegistrationModel(String firstName, String lastName, String fatherName, String motherName, String dob, String gender,
            String martialStatus, String emailId, String mobileNo, String panCard, String aadharcard, String userName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dob = dob;
        this.gender = gender;
        this.martialStatus = martialStatus;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.aadharcard = aadharcard;
        this.panCard = panCard;
        this.userName = userName;
    }

    public CustomerRegistrationModel(String flateNo, String street, String landmark, String pincode, String district,
            String city, String state, String country, String userName) {
        this.flateNo = flateNo;
        this.street = street;
        this.landmark = landmark;
        this.pincode = pincode;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.userName = userName;
    }

    public CustomerRegistrationModel(String accountNumber, String ifscCode, String micrCode, String netbanking, String mobileBanking,
            String chequeBook, String atmCard, String userName) {
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.micrCode = micrCode;
        this.netbanking = netbanking;
        this.mobileBanking = mobileBanking;
        this.chequeBook = chequeBook;
        this.atmCard = atmCard;
        this.userName = userName;
    }

}
