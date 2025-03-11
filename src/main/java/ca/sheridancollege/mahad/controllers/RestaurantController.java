package ca.sheridancollege.mahad.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.sheridancollege.mahad.beans.Restaurant;
import ca.sheridancollege.mahad.repositories.RestaurantRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
    
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}