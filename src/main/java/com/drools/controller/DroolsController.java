package com.drools.controller;

import com.drools.model.Applicant;
import com.drools.model.SuggestedRole;
import com.drools.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroolsController {

    @Autowired
    private DroolsService droolsService;

    @RequestMapping(value = "/getSuggestedRole", method = RequestMethod.GET, produces = "application/json")
    public SuggestedRole getSuggestedRole() {

        Applicant applicant = new Applicant("Davis", 37, 1600000.0, 11);
        SuggestedRole suggestedRole = new SuggestedRole();
        suggestedRole = droolsService.suggestRoleForApplicant(applicant, suggestedRole);
        return suggestedRole;
    }
}
