import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    Student student;

    @BeforeEach
    void initClass() {
        student = new Student("John", 20);
        System.out.println("Before class di jalanakan");
    }

    @AfterEach
    void cleanClass() {
        student = null;
    }

    @Test
    void testDataCreation() {
        assertNotNull(student);
        assertEquals("John", student.getName());
        assertEquals(20, student.getAge());
    }

    @Test
    void testStudentEnrolment() {
        student.enrollCourse("Math");
        student.enrollCourse("Physics");
        List<String> enrolledCourses = student.getEnrolledCourses();
        assertNotNull(enrolledCourses);
        assertEquals(2, enrolledCourses.size());
        assertTrue(enrolledCourses.contains("Math"));
        assertTrue(enrolledCourses.contains("Physics"));
    }

    @Test
    void testStudentGrade() {
        student.enrollCourse("Math");
        student.setGrade("Math", "A");
        assertEquals("A", student.getGrade("Math"));
    }
}