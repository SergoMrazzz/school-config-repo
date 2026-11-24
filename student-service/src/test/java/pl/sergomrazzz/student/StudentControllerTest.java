package pl.sergomrazzz.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StudentControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        StudentProperties properties = new StudentProperties();
        properties.setName("Demo School");
        properties.setAcademicYear("2026/2027");

        StudentProperties.Students students = new StudentProperties.Students();
        students.setMinimumAge(6);
        students.setMaximumClassSize(30);
        properties.setStudents(students);

        mockMvc = MockMvcBuilders.standaloneSetup(new StudentController(properties)).build();
    }

    @Test
    void returnsStudentConfiguration() throws Exception {
        mockMvc.perform(get("/api/students/config"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.service").value("student-service"))
                .andExpect(jsonPath("$.school").value("Demo School"))
                .andExpect(jsonPath("$.academicYear").value("2026/2027"))
                .andExpect(jsonPath("$.minimumAge").value(6))
                .andExpect(jsonPath("$.maximumClassSize").value(30));
    }
}
