package com.example.controller;

import com.example.common.Result;
import com.example.entity.Student;
import com.example.server.StudentServer;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
   private StudentServer studentServer;
//新增
    @PostMapping("/add")
    public Result add(@RequestBody Student student){
        studentServer.add(student);
        return Result.success();
    }
    //删除
    @DeleteMapping ("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        studentServer.deleteById(id);
        return Result.success();
    }
    //修改
    @PutMapping("/update")
    public Result update(@RequestBody Student student){
        studentServer.updateById(student);
        return Result.success();
    }
    //分页查询
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             Student student){
        PageInfo<Student> pageInfo = studentServer.selectPage(pageNum,pageSize,student);
        return Result.success(pageInfo);
    }
}
