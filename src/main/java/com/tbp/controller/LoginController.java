package com.tbp.controller;

import com.tbp.model.Person;
import com.tbp.model.UserSession;
import com.tbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserSession userSession;

    @RequestMapping(value = "doLogin",method = RequestMethod.GET)
    public String loginPage (){
        return "person/login";
    }

    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public String login (@RequestParam("username")String username,
                         @RequestParam("password") String password,
                         Map<String,Object> model){
        Person u =  personRepository.findByUsername(username);
        if(u != null && u.getPassword().equals(password)){
            userSession.AddLoggedUser(u);
            return "redirect:/scheduling/create";
        }else {
            model.put("message","Login not valid");
            return "person/login";
        }
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(){
        userSession.removedLoggedUser();
        return "person/login";
    }
}
