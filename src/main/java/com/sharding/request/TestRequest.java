package com.sharding.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TestRequest {
    private String name;
    private Date end;
    private Date start;
}
