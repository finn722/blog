package com.finn.blog.admin.service.impl;

import com.finn.blog.admin.entity.UserCredentialInfo;
import com.finn.blog.admin.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService {

    @Override
    public boolean sign() {
        return false;
    }

    @Override
    public UserCredentialInfo selectByName(String name) {
        return null;
    }


    @Override
    public boolean updatePasswordByName(String name) {
        return false;
    }

    @Override
    public boolean updateNameByTelephone(String telephone) {
        return false;
    }


}
