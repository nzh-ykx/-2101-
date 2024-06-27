package com.example.server;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Student;
import com.example.exception.CustomException;
import com.example.mapper.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServer {
    @Resource
    private StudentMapper studentMapper;
    //登录
    public Account login(Account account){
        Account dbStudent  = studentMapper.selectUsername(account.getUsername());// Account dbStudent：向上转型
//        dbStudent由Account实体类接收，但本质上是一个Student类（只是Account这种类型，返回的数据包含了整个的student所有字段）
        if (dbStudent == null){//没有用户
            throw new CustomException("账号或密码错误");
        }
        if(!account.getPassword().equals(dbStudent.getPassword())){//比较密码
            throw new CustomException("账号或密码错误");
        }
        //登录成功
        return dbStudent;
    }
//注册
    public void register(Account account) {
        Student student = new Student();
        student.setUsername(account.getUsername());//账号
        student.setPassword(account.getPassword());//密码
        this.add(student);//调用新增方法
    }
    //新增
    public void add(Student student){
        //先查询数据库进行判断，判断新增的学生数据库有没有
        Student dbStudent = studentMapper.selectUsername(student.getUsername());
    if (dbStudent != null){//已有同名账号不允许插入
        throw new CustomException("账号已存在");
    }
    //利用hutool依赖，用ObjectUtil.isEmpty(..)方法判断是否为空
    if (ObjectUtil.isEmpty(student.getName())){
       student.setName(student.getUsername());//如果学生没有名字，用账号作为学生名字
    }
    student.setRole(RoleEnum.STUDENT.name());
    studentMapper.insert(student);
    }


   //删除
    public void deleteById(Integer id) {
        studentMapper.deleteById(id);
    }
//修改
    public void updateById(Student student) {
        studentMapper.updateById(student);
    }
//分页查询
    public PageInfo<Student> selectPage(Integer pageNum,Integer pageSize,Student student) {
        PageHelper.startPage(pageNum,pageSize);
     List<Student> studentList = studentMapper.selectAll(student);
        return PageInfo.of(studentList);
    }
}

