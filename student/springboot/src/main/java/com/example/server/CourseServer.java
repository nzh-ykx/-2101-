package com.example.server;

import com.example.entity.Course;
import com.example.mapper.CourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class CourseServer {
    @Resource
    private CourseMapper courseMapper;
    //pageNum是当前的页码，pageSize是每页的个数
    public PageInfo<Course> selectPage(Integer pageNum,Integer pageSize,Course course){//
        PageHelper.startPage(pageNum,pageSize);//分页
        List<Course> courseList = courseMapper.selectAll(course);//把从mysql数据库中查询出来的数据封装成一个list列表
        return PageInfo.of(courseList);
    }
    //新增数据
    public void add(Course course) {
        courseMapper.insert(course);
    }
//修改数据
    public void updateById(Course course) {
        courseMapper.updateById(course);
    }
//删除数据
    public void deleteById(Integer id) {
        courseMapper.deleteById(id);
    }
}
