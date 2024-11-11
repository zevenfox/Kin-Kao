package ku.kinkao.controller;


import jakarta.validation.Valid;
import ku.kinkao.dto.ReviewRequest;
import ku.kinkao.service.RestaurantService;
import ku.kinkao.service.ReviewService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@Controller
@RequestMapping("/reviews")
public class ReviewController {


    @Autowired
    private ReviewService reviewService;


    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/show/{restaurantId}")
    public String getReviewPage(@PathVariable UUID restaurantId,
                                Model model) {


        model.addAttribute("restaurant",
                restaurantService.getOneRestaurant(restaurantId));


        return "review-restaurant";
    }


    @GetMapping("/add/{restaurantId}")
    public String getReviewForm(@PathVariable UUID restaurantId,
                                Model model) {


        model.addAttribute("restaurantId", restaurantId);
        model.addAttribute("reviewRequest", new ReviewRequest());


        return "review-add";
    }


    @PostMapping("/add")
    public String createReview(@Valid ReviewRequest review,
                               BindingResult result, Model model) {


        if (result.hasErrors()) {
            model.addAttribute("restaurantId", review.getRestaurantId());
            return "review-add";
        }


        reviewService.createReview(review);
        return "redirect:/reviews/show/" + review.getRestaurantId();
    }
}
