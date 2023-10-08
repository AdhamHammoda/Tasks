package com.sumerge.session2.config;

import com.sumerge.session2.Models.User;
import com.sumerge.session2.services.StaticUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
@Configuration
public class UserConfig {
    @Value("${alice.fullName}")
    String aliceFullName;

    @Value("${alice.gender}")
    char aliceGender;

    @Value("${alice.age}")
    double aliceAge;

    @Value("${bob.fullName}")
    String bobFullName;

    @Value("${bob.gender}")
    char bobGender;

    @Value("${bob.age}")
    double bobAge;

    @Bean(name="aliceService")
    @ConditionalOnMissingBean(name="aliceListOverride")
    StaticUserService getAliceService()
    {
        StaticUserService staticUserService=new StaticUserService();
        ArrayList<User> list1=new ArrayList<>();
        list1.add(new User(aliceFullName,aliceGender,aliceAge));
        staticUserService.setList(list1);
        return staticUserService;
    }
    @Bean(name="bobService")
    @ConditionalOnMissingBean(name="bobListOverride")
    StaticUserService getBobService()
    {
        StaticUserService staticUserService=new StaticUserService();
        ArrayList<User> list1=new ArrayList<>();
        list1.add(new User(bobFullName,bobGender,bobAge));
        staticUserService.setList(list1);
        return staticUserService;
    }
}
