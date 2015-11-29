/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.review.repository;

import co.agileventure.cloud.review.domain.Review;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Carlos
 */
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findAllByProductId(Long productId);
}
