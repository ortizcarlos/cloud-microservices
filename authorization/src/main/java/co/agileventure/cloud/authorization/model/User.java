/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.authorization.model;

/**
 *
 * @author Carlos
 */
public class User {

    /**id del usuario en el dataStore*/
    private String id;
    /**Nombre de la persona */
    private String givenName; 
    /**Apellido de la persona*/
    private String familyName;
    /**email*/
    private String email;
    /**
     * credenciales del usuario nombre de usuario(diferente al nombre 
     * de la persona) y pasabordo
     */
    private String userName;
    private String password;

    public User() {
    }

    public User(String id, String givenName, String familyName, String email, String userName, String password) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    } 

    public String getEmail() {
        return email;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
    
    
  
}
