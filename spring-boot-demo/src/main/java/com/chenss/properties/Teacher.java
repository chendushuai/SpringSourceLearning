package com.chenss.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "teacher")
public class Teacher {
    private String name;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        System.out.println("students");
        students.forEach(m -> System.out.println(m));

        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}
