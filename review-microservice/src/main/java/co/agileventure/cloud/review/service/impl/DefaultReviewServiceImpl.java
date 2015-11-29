/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.review.service.impl;

import co.agileventure.cloud.review.domain.Review;
import co.agileventure.cloud.review.repository.ReviewRepository;
import co.agileventure.cloud.review.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos
 */
@Service
public class DefaultReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review create(Review newReview) {
       return this.reviewRepository.save(newReview);
    }
    
    @Override
    public Review findOne(String id) {
        return this.reviewRepository.findOne(id);
    }

    @Override
    public List<Review> findAllByProductId(Long productId) {
        return this.reviewRepository.findAllByProductId(productId);
    }
    
}
