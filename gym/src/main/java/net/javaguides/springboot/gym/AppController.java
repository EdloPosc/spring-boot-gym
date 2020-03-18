package net.javaguides.springboot.gym;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/test")
    public String login(){
        System.out.println("AppController->welcome()");
        return "deneme";
    }
}
