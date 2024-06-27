package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.server.CourseServer;

import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;




@RestController//标注是一个接口
@RequestMapping("/course")//requestMapping里面的参数是一级路由
public class CourseController {
    @Resource
    private CourseServer courseServer;
//分页条件查询课程
@GetMapping("/selectPage")
public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,//前端传递过来的当前页数和每页数量，如果没有传递，默认传第一页每页5条
                         @RequestParam(defaultValue = "5")Integer pageSize,
                        Course course){//?name=xx & no=xx
//    PageInfo类中包含了list和total等等等
    PageInfo<Course> pageInfo = courseServer.selectPage(pageNum, pageSize,course);//返回的pageInfo对象中包含了total属性和list列表
    return Result.success(pageInfo);
}
//新增课程接口
@PostMapping("/add")
    public Result add(@RequestBody Course course){
    courseServer.add(course);
    return  Result.success();
}
//修改课程接口
    @PutMapping ("/update")
    public Result update(@RequestBody Course course){
        courseServer.updateById(course);
        return  Result.success();
    }
    //删除课程接口
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        courseServer.deleteById(id);
        return  Result.success();
    }
}
