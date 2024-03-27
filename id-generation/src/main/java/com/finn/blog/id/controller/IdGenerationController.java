package com.finn.blog.id.controller;

import com.finn.blog.api.id.IdGenerateClient;

import java.util.UUID;

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
