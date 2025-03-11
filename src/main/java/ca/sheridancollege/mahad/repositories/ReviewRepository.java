package ca.sheridancollege.mahad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.mahad.beans.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
