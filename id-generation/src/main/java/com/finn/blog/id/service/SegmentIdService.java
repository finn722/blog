package com.finn.blog.id.service;

import com.finn.blog.id.constants.Constants;
import com.finn.blog.id.exception.InitException;
import com.finn.blog.id.leaf.IDGen;
import com.finn.blog.id.leaf.common.PropertyFactory;
import com.finn.blog.id.leaf.common.Result;
import com.finn.blog.id.leaf.common.ZeroIDGen;
import com.finn.blog.id.leaf.segment.SegmentIDGenImpl;
import com.finn.blog.id.leaf.segment.dao.IDAllocDao;
import com.finn.blog.id.leaf.segment.dao.impl.IDAllocDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

public class SegmentIdService {

    public static final Logger logger = LoggerFactory.getLogger(SegmentIdService.class);

    private IDGen idGen;
    @Resource
    DataSource dataSource;

    public SegmentIdService(){

        Properties properties = PropertyFactory.getProperties();
        boolean flag = Boolean.parseBoolean(properties.getProperty(Constants.LEAF_SEGMENT_ENABLE, "true"));
        if(flag){

            IDAllocDao dao = new IDAllocDaoImpl(dataSource);
            idGen = new SegmentIDGenImpl();
            ((SegmentIDGenImpl)idGen).setDao(dao);
            if(idGen.init()){
                logger.info("Segment Service Init Successfully");
            }else{
                throw new InitException("Segment Service Init Fail");
            }
        }else{
            idGen = new ZeroIDGen();
            logger.info("Zero Id Gen Service Init Successfully");
        }
    }

    public Result getId(String key){
        return idGen.get(key);
    }

    public SegmentIDGenImpl getIdGen(){
        if(idGen instanceof SegmentIDGenImpl){
            return (SegmentIDGenImpl) idGen;
        }
        return null;
    }




}
