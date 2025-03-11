package ca.sheridancollege.mahad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.mahad.beans.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
