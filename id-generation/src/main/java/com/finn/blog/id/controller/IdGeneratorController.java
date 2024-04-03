package com.finn.blog.id.controller;

import com.finn.blog.api.id.IdGenerateClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdGeneratorController implements IdGenerateClient {


    @Override
    public String generateIdByUUID() {
        return null;
    }

    @Override
    public long generateSegmentId() {
        return 0;
    }
}
