package com.tbp.controller;

import com.tbp.model.Scheduling;
import com.tbp.model.Medico;
import com.tbp.model.Person;
import com.tbp.repository.MedicoRepository;
import com.tbp.repository.PersonRepository;
import com.tbp.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(name = "scheduling")
public class SchedulingController {

    @Autowired
    SchedulingRepository schedulingRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PersonRepository personRepository;


    @RequestMapping(value = "/scheduling/create",method = RequestMethod.GET)
    public String createPage(Map<String,Object> model) {
        Iterable<Medico> medicoList = medicoRepository.findAll();
        Iterable<Person> personList = personRepository.findAll();
        model.put("medicoList",medicoList);
        model.put("personList",personList);
        return "scheduling/create";
    }

    @RequestMapping(value = "/scheduling/create",method = RequestMethod.POST)
    public String save (@RequestParam("dataScheduling") String dataScheduling,
                      @RequestParam("idMedico") Medico medico,
                      @RequestParam("idPerson") Person person,
                      Map<String,Object> model) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = simpleDateFormat.parse(dataScheduling);
        Scheduling scheduling= new Scheduling();
        scheduling.setDataScheduling(date);
        scheduling.setMedico(medico);
        scheduling.setPerson(person);
        schedulingRepository.save(scheduling);
        return "redirect:/scheduling/list";
    }

    @RequestMapping(value = "/scheduling/list",method = RequestMethod.GET)
    public String listPage(Map<String,Object> model){
        Iterable<Scheduling> schedulingList = schedulingRepository.findAll();
        model.put("schedulingList",schedulingList);
        return "scheduling/list";
    }

    @RequestMapping(value = "/scheduling/edit",method = RequestMethod.GET)
    public String editPage (@RequestParam("id") Long id,Map<String,Object> model){
        Scheduling scheduling = schedulingRepository.findOne(id);

        model.put("scheduling",scheduling);

        Iterable<Medico> medicoList = medicoRepository.findAll();
        Iterable<Person> personList = personRepository.findAll();
        model.put("medicoList",medicoList);
        model.put("personList",personList);
        return "scheduling/edit";
    }

    @RequestMapping(value = "/scheduling/edit",method = RequestMethod.POST)
    public String save (@RequestParam("dataScheduling") String dataScheduling,
                      @RequestParam("idMedico") Long idMedico,
                      @RequestParam("idPerson") Long idPerson,
                      @RequestParam("idScheduling") Long idScheduling,
                      Map<String,Object> model) throws ParseException {

        Scheduling scheduling = schedulingRepository.findOne(idScheduling);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dataScheduling);

        scheduling.setDataScheduling(date);
        scheduling.setMedico(medicoRepository.findOne(idMedico));
        scheduling.setPerson(personRepository.findOne(idPerson));
        schedulingRepository.save(scheduling);
        return "redirect:/scheduling/list";
    }

    @RequestMapping(value = "scheduling/delete",method = RequestMethod.GET)
    public String delete (@RequestParam("id") Long id){
        schedulingRepository.delete(id);
        return "redirect:/scheduling/list";
    }
}
