package com.xschen.mylearn.proxy.reflect.entity;

/**
 * @author xschen
 */


public class Person {
    public String name;
    protected String age;
    private String hobby;

    public Person(String name, String age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }
}



