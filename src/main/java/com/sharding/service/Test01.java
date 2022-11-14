package com.sharding.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sharding.entity.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User(new BigDecimal("10"), new BigDecimal("11"), new BigDecimal("12"),BigDecimal.ZERO);
        User user1 = new User(new BigDecimal("20"), new BigDecimal("21"), new BigDecimal("22"),BigDecimal.ZERO);
        User user2 = new User(new BigDecimal("30"), new BigDecimal("31"), new BigDecimal("32"),BigDecimal.ZERO);
        User user3 = new User(new BigDecimal("40"), new BigDecimal("41"), new BigDecimal("42"),BigDecimal.ZERO);
        List<User> list = Arrays.asList(user, user1, user2, user3);
        User user0 = new User(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO);
        list.stream()
                .reduce((s1, s2) -> {
                    BigDecimal score2 = s1.getScore().add(s2.getScore());
                    BigDecimal score1 = s1.getScore2().add(s2.getScore2());
                    BigDecimal score0 = s1.getScore1().add(s2.getScore1());
                    BigDecimal add = s1.getScore1().add(s2.getScore())
                            .add(s1.getScore2()).add(s2.getScore2()).add(s2.getScore1())
                            .add(s1.getScore());
                    return new User(score2, score1, score0,add);
                }).ifPresent(result -> {
                    user0.setScore(result.getScore());
                    user0.setScore1(result.getScore1());
                    user0.setScore2(result.getScore2());
                    user0.setResult(result.getResult());
                });
        System.out.println(user0);
        String json = "{\"createTime\":\"2022-11-14\"}";

     /*   ActivityInfo bean = new ObjectMapper()
                .readerFor(ActivityInfo.class)
                .readValue(json);
        System.out.println(bean.getCreateTime());
        System.out.println(bean);*/

        String time="2022-11-14";
        String time1="2022-11-15";
        System.out.println(time.compareTo(time1));

    }
}
