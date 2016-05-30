/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.authorization.web.resources;

import co.agileventure.cloud.authorization.model.User;
import co.agileventure.cloud.authorization.web.transfer.UserCredential;
import co.agileventure.cloud.authorization.model.UserRepository;
import co.agileventure.cloud.authorization.support.AuthUtils;
import co.agileventure.cloud.authorization.support.PasswordService;
import co.agileventure.cloud.authorization.support.Token;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static String LOGING_ERROR_MSG = "Wrong username and/or password";

    private AuthUtils authUtils;
    private UserRepository userRepository;

    @Autowired
    public LoginController(AuthUtils authUtils,UserRepository userRepository) {
        this.authUtils = authUtils;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody @Valid final UserCredential credentials,
            @Context final HttpServletRequest request) {

        User currentUser = null;
        
        if (StringUtils.isEmpty(credentials.getPassword())
                || StringUtils.isEmpty(credentials.getEmail())) {
            return new ResponseEntity<String>(LOGING_ERROR_MSG, HttpStatus.BAD_REQUEST);
        }

        currentUser = this.userRepository.
                findByEmail(credentials.getEmail());

        if (currentUser != null && PasswordService.checkPassword(credentials.getPassword(),
                currentUser.getPassword())) {
            final String tokenStr = authUtils.createLoginToken(request.getRemoteHost(),
                    currentUser.getId(),currentUser.getEmail());
            return new ResponseEntity<Token>(new Token(tokenStr), HttpStatus.OK);
        }

        return new ResponseEntity<String>(LOGING_ERROR_MSG, HttpStatus.UNAUTHORIZED);
    }


}
