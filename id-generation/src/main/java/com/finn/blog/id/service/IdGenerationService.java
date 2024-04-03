package com.finn.blog.id.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.UUID;


@Service
public class IdGenerationService  {

    private static final Logger logger = LoggerFactory.getLogger(IdGenerationService.class);



    @Resource
    DataSource dataSource;


    public String generateIdByUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public long generateSegmentId(String key){


        return 0;








    }






}
