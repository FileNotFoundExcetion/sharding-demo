package com.sharding.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TestService2 implements TestService{
    public static void main(String[] args) {
        String date="20221009";
        String date1="20231010";
        AtomicReference<String> d=new AtomicReference<>();
        List<String> list=new ArrayList<>();
        list.add(date);
        list.add(date1);
        list.stream()
                .filter(Objects::nonNull)
                .max(String::compareTo)
                        .ifPresent(d::set);
        System.out.println(d.get());
    }
}
