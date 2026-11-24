package pl.sergomrazzz.grade;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GradeControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        GradeProperties properties = new GradeProperties();
        properties.setName("Demo School");
        properties.setAcademicYear("2026/2027");

        GradeProperties.Grades grades = new GradeProperties.Grades();
        grades.setMinimumPassingGrade(2);
        grades.setExamWeight(new BigDecimal("0.40"));
        properties.setGrades(grades);

        mockMvc = MockMvcBuilders.standaloneSetup(new GradeController(properties)).build();
    }

    @Test
    void returnsGradeConfiguration() throws Exception {
        mockMvc.perform(get("/api/grades/config"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.service").value("grade-service"))
                .andExpect(jsonPath("$.school").value("Demo School"))
                .andExpect(jsonPath("$.academicYear").value("2026/2027"))
                .andExpect(jsonPath("$.minimumPassingGrade").value(2))
                .andExpect(jsonPath("$.examWeight").value(0.40));
    }
}
