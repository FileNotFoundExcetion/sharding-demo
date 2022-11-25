package com.sharding.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Account {
    @JsonUnwrapped
    private Location location;
    @JsonUnwrapped
    private PersonInfo personInfo;

    @Getter
    @Setter
    @ToString
    public static class Location {
        private String provinceName;
        private String countyName;
    }
    @Getter
    @Setter
    @ToString
    public static class PersonInfo {
        private String userName;
        private String fullName;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        Account account=new Account();
        account.setLocation(new Location());
        account.setPersonInfo(new PersonInfo());
        System.out.println(objectMapper.writeValueAsString(account));
    }
}
