package com.amit.rest.webservices.welcome;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class WelcomeController {

   // @RequestMapping(method = RequestMethod.GET,value = "/welcome",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/welcome")
    public Welcome welcomeMessage() {
        return new Welcome("Welcome Adu...it really hard to guss the issue in Angular and Spring..but enjoyed it");
    }

    @GetMapping("/welcome/{name}")
    public Welcome welcomeMessage(@PathVariable String name) {
        return new Welcome("Welcome...."+ name);
    }
}
