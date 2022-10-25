package com.sharding.service;

import org.apache.shardingsphere.sql.parser.api.CacheOption;
import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.api.SQLVisitorEngine;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.MySQLStatement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Properties;

@Service
public class TestService2 implements TestService{

    @Transactional(rollbackFor = Exception.class)
    public void test1(){
           
    }

    public void test2(){
     test1();
    }

    public static void main(String[] args) {
        String format = MessageFormat.format("{0} is a dog", "me");
        String format1 = MessageFormat.format("{0} is a {1}", "me",0);
        System.out.println(format);
        System.out.println(format1);
        CacheOption cacheOption = new CacheOption(128, 1024L);
        SQLParserEngine parserEngine = new SQLParserEngine("MySQL", cacheOption);
        ParseASTNode parseASTNode = parserEngine.parse("SELECT t.id, t.name, t.age FROM table1 AS t ORDER BY t.id DESC;", false);
        SQLVisitorEngine visitorEngine = new SQLVisitorEngine("MySQL", "STATEMENT", false, new Properties());
        MySQLStatement sqlStatement = visitorEngine.visit(parseASTNode);
        System.out.println(sqlStatement.toString());
    }
}
