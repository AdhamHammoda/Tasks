package com.sumerge.stpsessionday1.configuration;

import com.sumerge.stpsessionday1.models.User;
import com.sumerge.stpsessionday1.services.StaticUserService;
import com.sumerge.stpsessionday1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

@Configuration
public class UserServiceConfiguration {


    @Bean
    UserService getUserService()
    {
        return new UserService();
    }


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

    @Bean(value="aliceService")
    StaticUserService getAliceService()
    {
        StaticUserService staticUserService=new StaticUserService();
        ArrayList<User> list1=new ArrayList<>();
        list1.add(new User(aliceFullName,aliceGender,aliceAge));
        staticUserService.setList(list1);
        return staticUserService;
    }

    @Bean(value="bobService")
    StaticUserService getBobService()
    {
        StaticUserService staticUserService=new StaticUserService();
        ArrayList<User> list1=new ArrayList<>();
        list1.add(new User(bobFullName,bobGender,bobAge));
        staticUserService.setList(list1);
        return staticUserService;
    }



}
