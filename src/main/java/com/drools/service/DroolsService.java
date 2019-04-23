package com.drools.service;

import com.drools.model.Applicant;
import com.drools.model.SuggestedRole;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroolsService {

    @Autowired
    private KieContainer kieContainer;

    public SuggestedRole suggestRoleForApplicant(Applicant applicant, SuggestedRole suggestedRole) {
        //get the stateful session
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(applicant);
        kieSession.setGlobal("suggestedRole",suggestedRole);
        kieSession.fireAllRules();
        kieSession.dispose();
        return suggestedRole;
    }
}
