package ku.kinkao.controller;

import ku.kinkao.dto.SignupRequest;
import ku.kinkao.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupService;

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        model.addAttribute("signupRequest", new SignupRequest());
        return "signup"; // return signup.html
    }


    @PostMapping("/signup")
    public String signupUser(@Valid SignupRequest member,
                             BindingResult result, Model model) {
        if (result.hasErrors())
            return "signup";

        if (signupService.isUsernameAvailable(member.getUsername())) {
            signupService.createMember(member);
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", "Username not available");
        }
        model.addAttribute("signupRequest", new SignupRequest());
        return "signup";
    }
}
