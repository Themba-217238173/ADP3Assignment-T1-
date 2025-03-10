package za.ac.cput.service;
/*
SubjectServiceTest.java
Test cases for SubjectService
Author: Mathew Fortuin (219069514)
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Subject;
import za.ac.cput.factory.SubjectFactory;
import za.ac.cput.service.impl.SubjectService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SubjectServiceTest {

    private static SubjectService subjectService = SubjectService.getService();
    private static Subject createdSubject = SubjectFactory.createSubject("ITS045",38,"AW12");

    @Test
    void a_create(){

        Subject create = subjectService.create(createdSubject);
        assertEquals(create.getSubjectID(),createdSubject.getSubjectID());
        System.out.println("ID#1: "+create.getSubjectID()+"\nID#2"+createdSubject.getSubjectID()+"\n");

    }

    @Test
    void b_read(){
        Subject read = subjectService.read(createdSubject.getSubjectID());
        assertNotNull(read);
        System.out.println("Reading SubjectID: "+read+"\n");

    }

    @Test
    void c_update(){

        Subject updated = new Subject.Builder().copy(createdSubject).setLecturerID("KB012").build();
        assertNotNull(subjectService.update(updated));

        System.out.println("Current Lecturer ID: "+updated.getLecturerID()+"\nOld Lecturer ID: "+createdSubject.getLecturerID());

    }

    @Test
    void d_delete(){
        boolean deleted = subjectService.delete(createdSubject.getSubjectID());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_getAll();
    }

    @Test
    void e_getAll() {

        System.out.println(subjectService.getAll()+"\n");
    }

}