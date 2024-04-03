package com.finn.blog.id.service;


import com.finn.blog.id.leaf.IDGen;
import com.finn.blog.id.leaf.common.PropertyFactory;
import com.finn.blog.id.leaf.common.Result;
import com.finn.blog.id.leaf.common.ZeroIDGen;
import com.finn.blog.id.leaf.snowflake.SnowflakeIDGenImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SnowflakeIdService {

    private Logger logger = LoggerFactory.getLogger(SnowflakeIdService.class);

    private IDGen idGen;

    public SnowflakeIdService() {
        Properties properties = PropertyFactory.getProperties();
        boolean flag = Boolean.parseBoolean(properties.getProperty("leaf.snowflake.enable", "true"));
        if(flag){
            String zkAddress = properties.getProperty("leaf.snowflake.zk.address");
            int port = Integer.parseInt(properties.getProperty("leaf.snowflake.port"));
            idGen = new SnowflakeIDGenImpl(zkAddress, port);
            if(idGen.init()){
                logger.info("Snowflake Service Init Successfully");
            }else {
                throw new RuntimeException("Snowflake Service Init Fail");
            }

        }else {
            idGen = new ZeroIDGen();
            logger.info("Zero ID Gen Service Init Successfully");
        }

    }
    public Result getId(String key){
        return idGen.get(key);
    }



}
