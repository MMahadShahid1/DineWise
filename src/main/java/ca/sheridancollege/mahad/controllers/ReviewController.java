package ca.sheridancollege.mahad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.sheridancollege.mahad.beans.Review;
import ca.sheridancollege.mahad.repositories.ReviewRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    
    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }
}