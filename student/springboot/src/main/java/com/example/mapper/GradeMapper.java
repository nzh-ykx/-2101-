package com.example.mapper;

import com.example.entity.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GradeMapper {
    //新增
    @Insert("insert into grade(student_id,course_id,score,comment,feedback) values(#{studentId},#{courseId},#{score},#{comment},#{feedback})")
    void insert(Grade grade);
//查询
    List<Grade> selectAll(Grade grade);//关联查询
//修改
    @Update("update grade set score = #{score},comment = #{comment},feedback = #{feedback} where id = #{id}")
    void update(Grade grade);
    @Select("select * from grade where student_id = #{student_id} and course_id = #{course_id}")
    Grade selectByCondition(Grade grade);
//删除
    @Delete("delete from grade where id = #{id}")
    void deleteById(Integer id);
}
