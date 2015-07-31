package com.OCare.controller;

import com.OCare.entity.ElderCondition;
import com.OCare.service.ElderConditionService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by Li on 2015/7/29.
 */
@Controller
@RequestMapping("/map")
public class ElderConditionController {
    @Autowired
    private ElderConditionService elderConditionService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String ShowElders(ModelMap map) {
//        Configuration cfg = new Configuration().configure();
//        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
//        ServiceRegistry service = ssrb.build();
//        SessionFactory factory = cfg.buildSessionFactory(service);
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();

//        List<ElderCondition> list = session.createCriteria(ElderCondition.class).list();
//        tx.commit();
        List<ElderCondition> list = elderConditionService.allElderConditions();
        map.addAttribute("Elders",list);
//        session.close();
        return "Map";
    }

    @RequestMapping(value = "/Refresh", method = RequestMethod.GET)
    public void RefreshCondition(ModelMap map,ServletResponse response) throws IOException {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        ServiceRegistry service = ssrb.build();
        SessionFactory factory = cfg.buildSessionFactory(service);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        List<ElderCondition> list = session.createCriteria(ElderCondition.class).list();
        tx.commit();
        System.out.println("------------------------------------");
        for(int i = 0;i<list.size();i++) {
            System.out.println(i+1+":"+list.get(i).getLatitude());
        }
        map.addAttribute("RefreshElders", list);
        session.close();

        int flag =1;
        PrintWriter pw = response.getWriter();
        pw.print(flag);
        pw.close();

    }

}
