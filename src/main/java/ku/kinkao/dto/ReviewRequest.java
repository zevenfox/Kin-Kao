package ku.kinkao.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;


@Data
public class ReviewRequest {


    @Min(1)
    @Max(5)
    private int rating;


    @NotBlank
    private String reviewText;


    @NotNull
    private UUID restaurantId;
}
