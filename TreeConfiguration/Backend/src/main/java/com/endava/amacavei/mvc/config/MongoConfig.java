package com.endava.amacavei.mvc.config;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by amacavei on 8/14/2015.
 */

@Configuration
public class MongoConfig {

    @Autowired
    MongoClient mongoClient;


    @Bean
    public DBCollection getDBCollection(){
        return getDB().getCollection("nodes");
    }
    @Bean
    public DB getDB(){
        return mongoClient.getDB("test");
    }
}
