package com.finn.blog.id.controller;

import com.finn.blog.api.id.IdGenerateClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IdGenerationController implements IdGenerateClient {
    @Override
    public String generateIdByUUID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String generateIdBySnowFlake() {
        return null;
    }
}
