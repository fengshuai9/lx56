package com.jk.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "t_user3")
public class UserBeanMd {


    private  String name;
    private String asd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsd() {
        return asd;
    }

    public void setAsd(String asd) {
        this.asd = asd;
    }
}
