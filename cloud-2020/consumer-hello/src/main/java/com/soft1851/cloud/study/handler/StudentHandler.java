package com.soft1851.cloud.study.handler;

import com.soft1851.cloud.study.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @description:
 * @author: mq_xu
 * @created: 2020/09/13 08:26
 */
@RequestMapping("/consumer")
@RestController
public class StudentHandler {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/student/one")
    public Student getOneStudent(){
        return restTemplate.getForObject("http://mqxu.com:8001/student/one",Student.class);
    }

    @GetMapping("/student/list")
    public List<Student> getStudentList(){
        return restTemplate.getForObject("http://mqxu.com:8001/student/list", List.class);
    }

}
