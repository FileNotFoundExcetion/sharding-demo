package com.sharding.emum;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 用户类型
 *
 * @author King
 */

@Getter
public enum UserType {
    type_1(1, "平台端管理员"),
    type_2(2, "代理"),
    type_3(3, "平台端操作员"),
    type_4(4, "代理操作员"),
    type_5(5, "部门负责人"),
    type_6(6, "部门操作员"),
    type_7(7, "渠道经理"),
    //代理才有业务员
    type_8(8, "业务员");

    private final int code;

    private final String desc;
    UserType(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public static void main(String[] args) {
        Class<UserType> userTypeClass = UserType.class;
        Map<String, UserType> collect = Arrays.stream(userTypeClass.getEnumConstants())
                .collect(Collectors.toMap(Enum::name, Function.identity()));
        System.out.println(collect);
        System.out.println(Long.MAX_VALUE+Long.MIN_VALUE);
    }
}
