package com.tbp.controller;

import com.tbp.model.Specialty;
import com.tbp.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SpecialtyController {

    @Autowired
    SpecialtyRepository specialtyRepository;

    @RequestMapping(value = "specialty/all",method = RequestMethod.GET)
    public Iterable<Specialty> findAll(){
        return specialtyRepository.findAll();
    }


    @RequestMapping(value = "specialty/create",method = RequestMethod.POST)
    public void create (@RequestBody Specialty specialty, Map<String,Object> model) {

        specialtyRepository.save(specialty);
        model.put("message","specialty" +specialty.getNome()+"created");

    }

    @RequestMapping(value = "specialty/save",method = RequestMethod.GET)
    public Specialty save (@RequestBody Specialty specialty){
        Specialty savedSpecialty = specialtyRepository.save(specialty);
        return savedSpecialty;
    }

    @RequestMapping(value = "specialty/update",method = RequestMethod.GET)
    public Specialty update (@RequestBody Specialty specialty,
                             @RequestBody Long id){

        specialtyRepository.findOne(id);
        Specialty savedSpecialty = specialtyRepository.save(specialty);
        return savedSpecialty;
    }

    @RequestMapping(value =  "specialty/list",method = RequestMethod.GET)
    public String listPage(Map<String,Object> model){
        Iterable<Specialty> all = specialtyRepository.findAll();
        model.put("specialtyList",all);
        return "specialty/list";
    }

    @RequestMapping(value = "specialty/edit",method = RequestMethod.GET)
    public  String editPage (@RequestBody Long id,Map<String,Object> model){
        Specialty specialty = specialtyRepository.findOne(id);
        model.put("specialty", specialty);
        return "specialty/edit";
    }

    @RequestMapping(value = "specialty/edit",method = RequestMethod.POST)
    public void update (@RequestBody Specialty specialty,@RequestBody Long id, Map<String,Object> model){
        specialtyRepository.findOne(id);
        specialtyRepository.save(specialty);
        model.put("specialty", specialty);
        model.put("message","specialty" +specialty+"edited");
    }
}
