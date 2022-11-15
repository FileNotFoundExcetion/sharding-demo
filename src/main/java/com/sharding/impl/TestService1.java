package com.sharding.impl;

import com.sharding.service.TestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

@Service
public class TestService1 implements TestService {

    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2022,9,1);
        LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfYear());
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfYear());
        long days=lastDay.toEpochDay()- firstDay.toEpochDay();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMdd");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyyMM");
        for (int i=0;i<=days;i++){
            LocalDate localDate = firstDay.plusDays(i);
            /*String day = dateTimeFormatter.format(localDate);
            String table="t_agent_order_"+"1"+"_"+day;*/
            String day1 = dateTimeFormatter1.format(localDate);
            String table="t_agent_order_"+"0"+"_"+day1;
            StringBuilder sb=new StringBuilder();
            sb.append("update ");
            sb.append(table).append(" ").append("t ");
            sb.append(" inner join ").append(" posx_merchant pm ")
            .append(" on pm.merchant_id=t.merchant_id");
            sb.append(" set t.merchant_no=pm.yinlian_merchant_no ");
            sb.append(" ,t.merchant_name=pm.merchant_name").append(";");
            System.out.println(sb);
          //  System.out.println();
            StringBuilder device=new StringBuilder();
            device.append("update ");
            device.append(table).append(" ").append("t ");
            device.append(" inner join ").append(" posx_device d ")
            .append(" on d.device_no=t.device_no");
            device.append(" set t.device_type=d.device_type ");
            device.append(" ,t.device_name=d.device_name").append(";");
            System.out.println(device);
           // System.out.println();
        }
    }
}
