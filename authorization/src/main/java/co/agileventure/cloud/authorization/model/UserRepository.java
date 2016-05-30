/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.authorization.model;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Carlos
 */
public interface UserRepository extends CrudRepository<User, String> {
     public User findByUserName(String userName);
     public User findByEmail(String email);
}
