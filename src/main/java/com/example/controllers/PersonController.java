package com.example.controllers;

import com.example.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Javier on 23/12/2015.
 */

@Controller
public class PersonController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Person person){
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "form";
        }

        return "redirect:/results";
    }

    @RequestMapping("/results")
    public String result(){
        return "results";
    }
}
