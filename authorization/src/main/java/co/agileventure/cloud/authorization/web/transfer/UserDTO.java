/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.authorization.web.transfer;

/**
 *
 * @author Carlos
 */
public class UserDTO {

    /*
    displayName
:
"carlos"
email
:
"carlosortizur@gmail.com"
password
:
"c3llpal+
    */
    

    /**
     * Nombre de la persona
     */
    private String givenName;
    /**
     * Apellido de la persona
     */
    private String familyName;
    /**
     * email
     */
    private String email;
    
    private UserCredential credentials;

    public UserDTO() {
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCredential getCredentials() {
        return credentials;
    }

    public void setCredentials(UserCredential credentials) {
        this.credentials = credentials;
    }
    
    
}
