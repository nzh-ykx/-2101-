package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.entity.Grade;
import com.example.server.GradeServer;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;




//成绩接口
@RestController
@RequestMapping("/grade")
public class GradeController {
    @Resource
    private GradeServer gradeServer;
//新增
    @PostMapping("/add")
    public Result add(@RequestBody Grade grade){
        gradeServer.insert(grade);
        return Result.success();
    }
    //修改
    @PutMapping("/update")
    public Result update(@RequestBody Grade grade){
        gradeServer.update(grade);
        return Result.success();
    }

    //分页条件查询
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,//前端传递过来的当前页数和每页数量，如果没有传递，默认传第一页每页5条
                             @RequestParam(defaultValue = "5")Integer pageSize,
                             Grade grade){//?name=xx & no=xx
    //    PageInfo类中包含了list和total等等等
        PageInfo<Grade> pageInfo = gradeServer.selectPage(pageNum, pageSize,grade);//返回的pageInfo对象中包含了total属性和list列表
        return Result.success(pageInfo);
    }

    //删除成绩接口
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        gradeServer.deleteById(id);
        return  Result.success();
    }
}
