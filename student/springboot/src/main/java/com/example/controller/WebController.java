package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.common.RoleEnum;
import com.example.entity.Account;
import com.example.server.AdminServer;
import com.example.server.StudentServer;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class WebController {
    @Resource
    private AdminServer adminServer;
    @Resource
    private StudentServer studentServer;

    /**
     * 默认请求接口
     */
    @GetMapping("/")
    public Result hello() {
        return Result.success();
    }
    //登录接口
    @PostMapping("/login")
    public Result login(@RequestBody Account account){  //接收前端传递过来的参数用Account（父类）接收，主要是通过role字段区分是管理员还是学生，使代码变得简洁
        Account dbAccount;//定义父类对象

        if (RoleEnum.ADMIN.name().equals(account.getRole())){//管理员登录
//            虽然Account dbAccount这个父类去接收，但是是根据实际返回的数据是什么，就给前端什么
             dbAccount = adminServer.login(account);
        }
        else if (RoleEnum.STUDENT.name().equals(account.getRole())) {//学生登录
             dbAccount = studentServer.login(account);
        }
        else {
            return Result.error("角色错误");
        }

        return Result.success(dbAccount);//把从数据库中查询出的的dbAccount返回给前端
    }
    //注册接口
    @PostMapping("/register")
    public Result register(@RequestBody Account account){  //接收前端传递过来的参数用Account（父类）接收，主要是通过role字段区分是管理员还是学生，使代码变得简洁
     if (ObjectUtil.isEmpty(account.getUsername())||ObjectUtil.isEmpty(account.getPassword())){
         return Result.error("账号和密码必填");
     }
       studentServer.register(account);
        return Result.success();
    }

}
