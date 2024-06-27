package com.example.server;

import com.example.entity.StudentCourse;
import com.example.exception.CustomException;
import com.example.mapper.StudentCourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class StudentCourseServer {
    @Resource
    private StudentCourseMapper studentCourseMapper;
    public void add(StudentCourse studentCourse) {
        //通过学生id和课程id做一次查询的筛选,查看这个学生之前有没有选过这门课程
       StudentCourse course = studentCourseMapper.selectByCondition(studentCourse);
       if (course != null){
           throw new CustomException("您已选过这门课程，请勿重复选课");
       }
        //新增
        studentCourseMapper.insert(studentCourse);
    }
//分页查询
    public PageInfo<StudentCourse> selectPage(Integer pageNum, Integer pageSize, StudentCourse studentCourse) {
        PageHelper.startPage(pageNum,pageSize);
      List<StudentCourse> list = studentCourseMapper.selectAll(studentCourse);
        return PageInfo.of(list);
    }
//删除选课
    public void deleteById(Integer id) {
        studentCourseMapper.deleteById(id);
    }
}
