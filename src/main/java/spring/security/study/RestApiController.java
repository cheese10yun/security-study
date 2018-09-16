package spring.security.study;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RestApiController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public Principal home(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public Authentication authentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}
