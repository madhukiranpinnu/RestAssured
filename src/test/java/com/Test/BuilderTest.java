package com.Test;

import POJOClass.Student;
import POJOClass.Student1;
import POJOClass.StudentBuilder;
import org.testng.annotations.Test;

public class BuilderTest {
    @Test
    public void Test1(){
        Student student=StudentBuilder
                .builder()
                .setId(100)
                .setFirst_name("madhu")
                .setLast_name("kiran")
                .setEmail("ma@gmail.com")
                .setEmail("mkiran918@gmail.com")
                .build();
        System.out.println(student.getId());
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        System.out.println(student.getEmail());
    }
    @Test
    public void Test2(){
        Student student= Student.StudentBuilder1.Builder()
                .setId(1000)
                .setFirst_name("madhukiran")
                .setLast_name("pinnu")
                .setEmail("ma@gmail.com")
                .build();
        System.out.println(student.getId());
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        System.out.println(student.getEmail());
    }
    @Test
    public void Test3(){
        Student1 student= Student1.builder()
                .setId(1000)
                .setFirst_name("madhukiran")
                .setLast_name("pinnu")
                .setEmail("ma@gmail.com")
                        .getStudent();
        System.out.println(student.getId());
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        System.out.println(student.getEmail());
    }
}
