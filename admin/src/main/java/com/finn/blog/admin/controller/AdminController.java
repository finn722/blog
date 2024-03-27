package com.finn.blog.admin.controller;

import com.finn.blog.admin.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminController {

    @Resource
    private AdminService adminService;


    @GetMapping("/hello")
    public String welcome(){
        return "Hello,Master";
    }

    public boolean updatePassword(String newPassword ,String name) {
        return true;
    }






}
