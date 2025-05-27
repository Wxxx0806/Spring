package com.wx;

import com.wx.mapper.StudentMapper;
import com.wx.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void TestStudent(){
        List<Student> studentList=studentMapper.list();
        studentList.stream().forEach(student -> {
            System.out.println(student.toString());
        });
    }
}
