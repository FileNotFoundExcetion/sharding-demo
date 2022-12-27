package com.sharding.service;

import java.io.Serializable;

public class Singleton implements Serializable {
    private final static Singleton singleInstance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleInstance;
    }
    //https://blog.csdn.net/qcl108/article/details/102258871
    //https://blog.csdn.net/u012745499/article/details/120379399
    public Object readResolve(){
        return singleInstance;
    }
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        String ss="1,3";
        System.out.println(ss.split(",").length);

    }
}
