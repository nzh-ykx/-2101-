package com.example.controller;

import com.example.common.Result;
import com.example.entity.StudentCourse;
import com.example.server.StudentCourseServer;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/studentCourse")
//学生选课
public class StudentCourseController {
    @Resource
    private StudentCourseServer studentCourseServer;
    //新增
    @PostMapping("/add")
    public Result add(@RequestBody StudentCourse studentCourse){
        studentCourseServer.add(studentCourse);
        return  Result.success();
    }
    //分页查询展示课程
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             StudentCourse studentCourse){
        PageInfo<StudentCourse> pageInfo = studentCourseServer.selectPage(pageNum,pageSize,studentCourse);
        return Result.success(pageInfo);
    }
    //删除选课接口
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        studentCourseServer.deleteById(id);
        return  Result.success();
    }
}
