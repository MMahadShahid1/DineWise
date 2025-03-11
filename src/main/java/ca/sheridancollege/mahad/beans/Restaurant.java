package ca.sheridancollege.mahad.beans;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurants")
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String location;
    private String cuisineType;
    private Double rating;  // Average rating
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}