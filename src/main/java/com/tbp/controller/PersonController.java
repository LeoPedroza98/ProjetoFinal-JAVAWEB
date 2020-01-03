package com.tbp.controller;


import com.tbp.model.Person;
import com.tbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/person/create",method = RequestMethod.GET)
    public String createPage() {
        return "person/create";
    }

    @RequestMapping(value = "/person/create",method = RequestMethod.POST)
    public void save (@RequestParam ("name")String nome,
                      @RequestParam("email") String email,
                      @RequestParam("password") String password,
                      @RequestParam("username") String username,
                      Map<String,Object> model){

        Person person = new Person();
        person.setNome(nome);
        person.setEmail(email);
        person.setPassword(password);
        person.setUsername(username);
        personRepository.save(person);
        model.put("message","Person" + nome+ "Created");
    }

    @RequestMapping(value = "/person/list",method = RequestMethod.GET)
    public String listPage(Map<String,Object> model){
        Iterable<Person> personList = personRepository.findAll();
        model.put("personList",personList);
        return "person/list";
    }

    @RequestMapping(value = "/person/edit",method = RequestMethod.GET)
    public String editPage (@RequestParam("id") Long id,Map<String,Object> model){
        Person person = personRepository.findOne(id);
        model.put("person",person);
        return "person/edit";
    }

    @RequestMapping(value = "/person/edit",method = RequestMethod.POST)
    public void  update(@RequestParam("name") String nome,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("idPerson") Long idPerson,
                        Map<String,Object>model){

        Person person = personRepository.findOne(idPerson);
        person.setNome(nome);
        person.setEmail(email);
        person.setPassword(password);
        personRepository.save(person);

        model.put("person",person);
        model.put("message","Person"+nome+ "edited");
    }

    @RequestMapping(value = "person/delete",method = RequestMethod.GET)
    public String delete (@RequestParam("id") Long id){
        personRepository.delete(id);
        return "redirect:/person/list";
    }
}
