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
public class UserCredential {
    private String userName;
    private String email;
    private String password;

    public UserCredential() {
    }

    public UserCredential(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
