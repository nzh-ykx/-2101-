package com.example.mapper;

import com.example.entity.StudentCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentCourseMapper {
@Insert("insert into student_course(name,no,student_id,course_id) values (#{name},#{no},#{student_id},#{course_id})")
    void insert(StudentCourse studentCourse);
@Select("select * from  student_course where student_id = #{student_id} and course_id = #{course_id}")
    StudentCourse selectByCondition(StudentCourse studentCourse);
//分页条件查询
//    @Select("select * from  student_course where name like concat('%',#{name},'%') and no like concat('%',#{no},'%')")
    List<StudentCourse> selectAll(StudentCourse studentCourse);
//删除选课
    @Delete("delete from student_course where id = #{id}")
    void deleteById(Integer id);
}
