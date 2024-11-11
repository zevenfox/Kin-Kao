package ku.kinkao.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class RestaurantRequest {


    @NotBlank
    private String name;


    @NotBlank
    private String type;


    @NotBlank
    private String address;
}
