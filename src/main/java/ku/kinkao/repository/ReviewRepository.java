package ku.kinkao.repository;


import ku.kinkao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;


@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
}
