package com.example.mapper;

import com.example.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
    //多条件模糊查询
    @Select("select * from course where name like concat('%',#{name},'%') and no like concat('%',#{no},'%') and teacher like concat('%',#{teacher},'%') order by id desc")
    List<Course> selectAll(Course course);//把从mysql数据库中查询出来的数据封装成一个list列表

    //新增数据
    @Insert("insert into course(name,no,descr,times,teacher) values(#{name},#{no},#{descr},#{times},#{teacher})")
    void insert(Course course);
@Update("update course set name = #{name},no = #{no},descr = #{descr},times = #{times},teacher = #{teacher} where id = #{id}")
    void updateById(Course course);
@Delete("delete from course where id = #{id}")
    void deleteById(Integer id);
}
