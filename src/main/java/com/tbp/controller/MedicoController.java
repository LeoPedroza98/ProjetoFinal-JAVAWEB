package com.tbp.controller;

import com.tbp.model.Medico;
import com.tbp.model.Specialty;
import com.tbp.repository.MedicoRepository;
import com.tbp.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    SpecialtyRepository specialtyRepository;

    @RequestMapping(value = "/medico/create",method = RequestMethod.GET)
    public String createPage(Map<String,Object> model){
        Iterable<Specialty> mySpecialty = specialtyRepository.findAll();
        model.put("mySpecialty",mySpecialty);
        return "medico/create";
    }

    @RequestMapping(value = "/medico/create",method = RequestMethod.POST)
    public String save (@RequestParam("nome")String nome,
                      @RequestParam("crm") String crm,
                      @RequestParam("idSpecialty") Long idSpecialty,
                      Map<String,Object> model){

        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setCrm(crm);
        Specialty specialty = specialtyRepository.findOne(idSpecialty);
        medico.setMySpecialty(specialty);
        medicoRepository.save(medico);
        model.put("message","Medico" +nome+"Created");
        return"redirect:/medico/list";
    }

    @RequestMapping(value = "/medico/list",method = RequestMethod.GET)
    public String listPage(Map<String,Object> model){
        Iterable<Medico> medicoList = medicoRepository.findAll();
        model.put("medicoList",medicoList);
        return "medico/list";
    }

    @RequestMapping(value = "/medico/edit",method = RequestMethod.GET)
    public String edit (@RequestParam(name = "id") Long idMedico,
                        Map<String,Object> model){
        Medico medico = medicoRepository.findOne(idMedico);
        model.put("medico",medico);
        Iterable<Specialty> mySpecialty = specialtyRepository.findAll();
        model.put("specialtyList",mySpecialty);
        return "medico/edit";

    }

    @RequestMapping(value = "/medico/edit",method = RequestMethod.POST)
    public String  update(@RequestParam("nome") String nome,
                        @RequestParam("crm") String crm,
                        @RequestParam("idMedico") Long idMedico,
                        @RequestParam("idSpecialty") Long idSpecialty,
                        Map<String,Object>model){

        Medico medico= medicoRepository.findOne(idMedico);
        medico.setNome(nome);
        medico.setCrm(crm);


        Specialty specialty = specialtyRepository.findOne(idSpecialty);
        medico.setMySpecialty(specialty);
        medicoRepository.save(medico);
        //model.put("medico",medico);
        return "redirect:/medico/list";
        //model.put("message","Medico"+nome+ "edited");
    }

    @RequestMapping(value = "medico/delete",method = RequestMethod.GET)
    public String delete (@RequestParam("id") Long id){
        medicoRepository.delete(id);
        return "redirect:/medico/list";
    }
}
