package com.xv.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/user/{id}")
    @ResponseBody
    private ModelAndView getUser(@PathVariable Integer id, Model model){
        String uri="https://jsonplaceholder.typicode.com/todos/"+id;
        RestTemplate restTemplate = new RestTemplate();

        User user = restTemplate.getForObject(uri, User.class );
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user",user);
        System.out.println("User: " + user);
        return modelAndView;
    }
}
