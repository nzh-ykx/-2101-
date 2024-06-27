package com.example.server;

import com.example.entity.Course;
import com.example.entity.Grade;
import com.example.exception.CustomException;
import com.example.mapper.GradeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class GradeServer {
    @Resource
    private GradeMapper gradeMapper;
    //新增
    public void insert(Grade grade) {
        Grade dbGrade = gradeMapper.selectByCondition(grade);
        if (dbGrade != null){//已经打过分了
          throw new CustomException("已经打过分数,请勿重新打分");
        }
        gradeMapper.insert(grade)
        ;
    }
//查询
    public PageInfo<Grade> selectPage(Integer pageNum, Integer pageSize, Grade grade) {
        PageHelper.startPage(pageNum,pageSize);//分页
        List<Grade> gradeList = gradeMapper.selectAll(grade);//把从mysql数据库中查询出来的数据封装成一个list列表
        return PageInfo.of(gradeList);
    }
//修改
    public void update(Grade grade) {
        gradeMapper.update(grade);
    }
//删除
    public void deleteById(Integer id) {
        gradeMapper.deleteById(id);
    }
}
