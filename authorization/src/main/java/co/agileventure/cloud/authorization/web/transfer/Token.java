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
public class Token {

    private String token;

    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
