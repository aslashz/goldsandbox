package org.easyrulestest;

import org.easyrules.api.RulesEngine;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

public class Main {

    public static void main(String[] args) {
        // here I compare 2 different rule engines //
        
        Employee arturia = new Employee("arturia", new Date(15, 10, 2015));
        Employee nero = new Employee("nero", new Date(16, 10, 2015));

        Date wantLeave = new Date(1, 12, 2015);
        int howLong = 3;
        // using drools //
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");
        LeaveStatus leaveArturia = new LeaveStatus(arturia, wantLeave, howLong);
        LeaveStatus leaveNero = new LeaveStatus(nero, wantLeave, howLong);
        kSession.insert(leaveArturia);
        kSession.insert(leaveNero);
        kSession.fireAllRules();
        System.out.println(leaveArturia.getEmployee() + " " + leaveArturia.getStatus());
        System.out.println(leaveNero.getEmployee() + " " + leaveNero.getStatus());
        
        
        // using easyrules //
        arturia = new Employee("arturia", new Date(15, 10, 2015));
        nero = new Employee("nero", new Date(16, 10, 2015));
        RulesEngine rulesEngine = aNewRulesEngine().build();
        rulesEngine.registerRule(new EasyRulesAcceptLeave(leaveArturia));
        rulesEngine.registerRule(new EasyRulesRejectLeave(leaveArturia));
        rulesEngine.registerRule(new EasyRulesAcceptLeave(leaveNero));
        rulesEngine.registerRule(new EasyRulesRejectLeave(leaveNero));
        rulesEngine.fireRules();
        System.out.println(leaveArturia.getEmployee() + " " + leaveArturia.getStatus());
        System.out.println(leaveNero.getEmployee() + " " + leaveNero.getStatus());
        
    }

}