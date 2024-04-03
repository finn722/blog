package com.finn.blog.api.id;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;


@Api(value = "Id Generation Client", tags = "Id")
public interface IdGenerateClient {

    @ApiOperation(value = "Generate Id", notes = "Distributed unique id")
    @GetMapping("/id/generate")
    String generateIdByUUID();

    long generateSegmentId();

      
}
