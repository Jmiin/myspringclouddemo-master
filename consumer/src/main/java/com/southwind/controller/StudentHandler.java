package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RequestMapping("/consumer")
@RestController
public class StudentHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll") //以rest为风格的url不能使用大写，不能使用驼峰，不能使用下划线，只能使用模块名 如：@GetMapping("/user")
    public Collection<Student> findAll(){

        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
        //或者   restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class.getBody());
    }

    @GetMapping("/findById/{id}") //@GetMapping("/user/{id}")
    public Student findById(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Student.class,id);
    }

    @PostMapping("/save") //@PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/student/save",student,Student.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/student/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/student/deleteById/{id}",id);
    }
}
