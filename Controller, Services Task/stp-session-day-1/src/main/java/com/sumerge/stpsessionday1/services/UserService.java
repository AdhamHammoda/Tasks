package com.sumerge.stpsessionday1.services;

import com.sumerge.stpsessionday1.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users=new ArrayList<>(List.of(
            new User("Ahmed",'M',20.0)
            ,new User("Mohamed",'M',18.0)
    ));

    public List<User> getUsersData()
    {
        return users;
    }
    public void addUser(User user)
    {
        users.add(user);
    }
    public void deleteUser(User user)
    {
        int idx=-1;
        for(int i=0;i<users.size();i++)
        {
            User user1=users.get(i);
            if(user1.getFullName().equals(user.getFullName())
            && user1.getGender()==user.getGender()
            && user1.getAge()==user.getAge())
            {
                idx=i;
                break;
            }
        }
        if(idx!=-1)
        {
            users.remove(idx);
        }
    }

    public void putUser(String fullName,double newAge)
    {
        System.out.println(fullName);
        int idx=-1;
        for(int i=0;i<users.size();i++)
        {
            User user1=users.get(i);
            if(user1.getFullName().equals(fullName))
            {
                idx=i;
                break;  
            }
        }
        if(idx!=-1)
        {
            users.get(idx).setAge(newAge);
        }
        for (User user:users)
        {
            System.out.println(user.getAge());
        }
    }


}
