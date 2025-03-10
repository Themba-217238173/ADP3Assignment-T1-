package za.ac.cput.service;
/*
CourseServiceTest.java
Test cases for CourseService
Author: Mathew Fortuin (219069514)
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Course;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.service.impl.CourseService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class CourseServiceTest {

    private static CourseService courseService = CourseService.getService();
    private static Course createdCourse = new CourseFactory().createCourse("ICT:APP20","ICT: Applications Development","Fundamentals of application architecture in the software indsutry");

    @Test
    void a_create(){

        Course createCourse = courseService.create(createdCourse);
        assertEquals(createCourse.getCourseName(),createdCourse.getCourseName());
        System.out.println("ID#1: "+createCourse.getCourseId()+"\nID#2"+createdCourse.getCourseId()+"\n");

    }

    @Test
    void b_read(){
        Course read = courseService.read(createdCourse.getCourseId());
        assertNotNull(read);
        System.out.println("Reading CourseID: "+read+"\n");

    }

    @Test
    void c_update(){

        Course updated = new Course.Builder().copy(createdCourse).setDepartmentId("IT30").build();
        assertNotNull(courseService.update(updated));

        System.out.println("Current department ID: "+updated.getDepartmentId()+"\nOld Department ID: "+createdCourse.getDepartmentId());

    }

    @Test
    void d_delete(){
        boolean deleted = courseService.delete(createdCourse.getCourseId());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_getAll();
    }

    @Test
    void e_getAll() {

        System.out.println(courseService.getAll()+"\n");
    }

}