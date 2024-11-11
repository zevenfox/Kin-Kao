package ku.kinkao.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;


@Data
@Entity
public class Review {


    @Id
    @GeneratedValue
    private UUID id;


    private int rating;
    private String reviewText;
    private Instant createdAt;


    @ManyToOne
    private Restaurant restaurant;
}
