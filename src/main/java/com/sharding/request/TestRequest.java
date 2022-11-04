package com.sharding.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class TestRequest {
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;
}
