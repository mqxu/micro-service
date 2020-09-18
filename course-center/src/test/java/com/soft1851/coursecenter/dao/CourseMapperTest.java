package com.soft1851.coursecenter.dao;

import com.soft1851.coursecenter.domain.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void get(){
        Course course = courseMapper.selectByPrimaryKey(1);
        System.out.println(course);
    }

    @Test
    void list(){
        List<Course> courses = courseMapper.selectAll();
        System.out.println(courses);
    }

}