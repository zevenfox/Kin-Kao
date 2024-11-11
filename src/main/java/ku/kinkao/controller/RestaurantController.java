package ku.kinkao.controller;


import jakarta.validation.Valid;
import ku.kinkao.dto.RestaurantRequest;
import ku.kinkao.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/restaurants")
public class RestaurantController {


    @Autowired
    private RestaurantService service;


    @GetMapping
    public String getAllRestaurantPage(Model model) {
        model.addAttribute("restaurants", service.getAllRestaurants());
        return "restaurant-all";
    }


    @GetMapping("/add")
    public String getRestaurantAddPage(Model model) {
        model.addAttribute("restaurantRequest", new RestaurantRequest());
        return "restaurant-add";
    }


    @PostMapping("/add")
    public String addRestaurant(@Valid RestaurantRequest request,
                                BindingResult result, Model model) {
        if (result.hasErrors())
            return "restaurant-add";


        service.createRestaurant(request);
        return "redirect:/restaurants";
    }
}