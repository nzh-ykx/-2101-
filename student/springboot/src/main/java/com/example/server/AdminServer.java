package com.example.server;
import com.example.entity.Account;
import com.example.exception.CustomException;
import com.example.mapper.AdminMapper;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;




@Service
public class AdminServer {
    @Resource
    private AdminMapper adminMapper;
    //登录
    public Account login(Account account){
        Account dbAdmin  = adminMapper.selectUsername(account.getUsername());// Account dbAdmin ：向上转型
        if (dbAdmin == null){//没有用户
            throw new CustomException("账号或密码错误");
        }
        if(!account.getPassword().equals(dbAdmin.getPassword())){//比较密码
            throw new CustomException("账号或密码错误");
        }
        //登录成功
        return dbAdmin;
    }
}
