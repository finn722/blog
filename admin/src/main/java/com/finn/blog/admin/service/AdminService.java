package com.finn.blog.admin.service;

import com.finn.blog.admin.entity.UserCredentialInfo;

public interface AdminService {

    /**
     * 登录
     * @return
     */
    boolean sign();

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    UserCredentialInfo selectByName(String name);

    /**
     * 根据用户名修改密码
     * @param name
     * @return
     */
    boolean updatePasswordByName(String name);

    /**
     * 根据手机号更新用户名
     * @param telephone
     * @return
     */
    boolean updateNameByTelephone(String telephone);






}
