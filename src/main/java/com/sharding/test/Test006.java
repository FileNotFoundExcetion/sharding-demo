package com.sharding.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * ALTER TABLE t_agent_month_profit_stat_202212 add direct_total_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '直属分润(不含减免)总金额' AFTER direct_total_profit_amt;
 * ALTER TABLE t_agent_month_profit_stat_202212 add direct_total_own_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '直属净分润(不含减免)总金额' AFTER direct_total_own_profit_amt;
 * ALTER TABLE t_agent_month_profit_stat_202212 add un_direct_total_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '非直属分润(不含减免)总金额' AFTER un_direct_total_profit_amt;
 * ALTER TABLE t_agent_month_profit_stat_202212 add un_direct_total_own_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '非直属净分润(不含减免)总金额' AFTER un_direct_total_own_profit_amt;
 */
public class Test006 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate firstmonth = now.with(TemporalAdjusters.firstDayOfYear());
    //    LocalDate lasttmonth = now.with(TemporalAdjusters.lastDayOfYear());
        for (int i=0;i<=11;i++){
            LocalDate localDate = firstmonth.plusMonths(i);
            String yearMonth = localDate.format(DateTimeFormatter.ofPattern("yyyyMM"));
            String tableName = String.format("t_agent_month_profit_stat_%s", yearMonth);
           // String tableName = String.format("t_agent_day_profit_stat_%s", yearMonth);
            String sql=String.format("ALTER TABLE %s add direct_total_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '直属分润(不含减免)总金额' AFTER direct_total_profit_amt ",tableName);
            String sql1=String.format(" %s add direct_total_own_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '直属净分润(不含减免)总金额' AFTER direct_total_own_profit_amt ",",");
            String sql2=String.format(" %s add un_direct_total_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '非直属分润(不含减免)总金额' AFTER un_direct_total_profit_amt ",",");
            String sql3=String.format(" %s add un_direct_total_own_profit_unannul_amt  decimal(16, 4) DEFAULT 0 COMMENT '非直属净分润(不含减免)总金额' AFTER un_direct_total_own_profit_amt; ",",");
            System.out.println(sql + sql1 + sql2 + sql3);
        }

    }
}
