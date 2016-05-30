/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.authorization.web.resources;

import co.agileventure.cloud.authorization.model.User;
import co.agileventure.cloud.authorization.model.UserRepository;
import co.agileventure.cloud.authorization.support.AuthUtils;
import co.agileventure.cloud.authorization.support.PasswordService;
import co.agileventure.cloud.authorization.support.Token;
import co.agileventure.cloud.authorization.web.transfer.UserDTO;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
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
@RequestMapping("/signup")
public class SignUpController {

    private UserRepository userRepository;
    private AuthUtils authUtils;

    @Autowired
    public SignUpController(UserRepository userRepository, AuthUtils authUtils) {
        this.userRepository = userRepository;
        this.authUtils = authUtils;
    }   

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody @Valid final UserSignup signup, 
            @Context final HttpServletRequest request) {
        
        String userid = UUID.randomUUID().toString();
        
        User newUser = new User(
                userid, 
                "",
                "", 
                signup.email,
                signup.displayName, 
                PasswordService.
                        hashPassword(signup.password));
        
        userRepository.save(newUser);
        
        final String tokenStr = authUtils.createLoginToken(request.getRemoteHost(),
                newUser.getId(), newUser.getPassword());
        return new ResponseEntity<Token>(new Token(tokenStr), HttpStatus.CREATED);
    }
    
     @SuppressWarnings("unused")
    private static class UserSignup {
        public String displayName;
        public String email;
        public String password;
    }
}
