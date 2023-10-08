package com.sumerge.stpsessionday1.configuration;

import com.sumerge.session2.Models.User;
import com.sumerge.session2.services.StaticUserService;
import com.sumerge.stpsessionday1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

    @Bean(value="aliceListOverride")
    StaticUserService getAliceService()
    {
        StaticUserService staticUserService=new StaticUserService();
        ArrayList<User> list1=new ArrayList<>();
        list1.add(new User("aliceAlice",'M',23.2));
        staticUserService.setList(list1);
        return staticUserService;
    }

    @Bean(value ="bobListOverride")
    StaticUserService getBobService()
    {
        StaticUserService staticUserService=new StaticUserService();
        ArrayList<User> list1=new ArrayList<>();
        list1.add(new User("bobBob",'M',26.6));
        staticUserService.setList(list1);
        return staticUserService;
    }



}
