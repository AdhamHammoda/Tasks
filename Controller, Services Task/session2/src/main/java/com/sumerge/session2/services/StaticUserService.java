package com.sumerge.session2.services;


import com.sumerge.session2.Models.User;

import java.util.ArrayList;

public class StaticUserService {
    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }

    ArrayList<User> list;
}
