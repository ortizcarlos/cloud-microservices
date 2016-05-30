/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.review.rest;

import co.agileventure.cloud.review.domain.Review;
import co.agileventure.cloud.review.service.ReviewService;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos
 */
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RestController
@RequestMapping("/")
public class ReviewController {
    
    private ReviewService reviewService;

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }   
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review create(@RequestBody @Valid Review review) {
        return reviewService.create(review);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public List<Review> findByProductId(@PathVariable("id") Long id) {
        return reviewService.findAllByProductId(id);
    }
    
}
