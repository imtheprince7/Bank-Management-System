/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

/**
 *
 * @author princ
 */
public class Users {
    
    private String applicationNumber;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String dateOfBirth;
    private String gender;
    private String martialStatus;
    private String emailId;
    private String mobileNumber;

   
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Users(String applicationNumber, String firstName, String lastName, String fatherName, String motherName, String dateOfBirth, String gender, String martialStatus, String emailId, String mobileNumber) {
        this.applicationNumber = applicationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.martialStatus = martialStatus;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }
    
    
    
}
