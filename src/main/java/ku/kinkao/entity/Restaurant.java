package ku.kinkao.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.List;
import java.util.UUID;


@Data
@Entity
public class Restaurant {


    @Id
    @GeneratedValue
    private UUID id;


    private String name;
    private String type;
    private String address;
    private Instant createdAt;


    @OneToMany(mappedBy = "restaurant")
    List<Review> reviews;
}
