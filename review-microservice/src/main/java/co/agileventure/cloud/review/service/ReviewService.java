/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.review.service;

import co.agileventure.cloud.review.domain.Review;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface ReviewService {
    Review findOne(String id);
    Review create(Review newReview);
    List<Review> findAllByProductId(Long productId);
}
