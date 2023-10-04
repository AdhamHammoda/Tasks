package com.sumerge.stpsessionday1.services;

import com.sumerge.stpsessionday1.models.User;

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
