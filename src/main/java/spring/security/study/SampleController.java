package spring.security.study;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.security.study.user.User;

import javax.validation.Valid;

@Controller
public class SampleController {

    @RequestMapping("/login")
    public String login() {
        return "loginPage";
    }


    @RequestMapping(value = "signup")
    public ModelAndView registrationForm() {
        return new ModelAndView("registrationPage", "user", new User());
    }

//    @RequestMapping(value = "user/register")
//    public ModelAndView registerUser(@Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return new ModelAndView("registrationPage", "user", user);
//        }
//        try {
//            userService.registerNewUser(user);
//        } catch (EmailExistsException e) {
//            result.addError(new FieldError("user", "email", e.getMessage()));
//            return new ModelAndView("registrationPage", "user", user);
//        }
//        return new ModelAndView("redirect:/login");
//    }

}
