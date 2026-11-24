package pl.sergomrazzz.schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ScheduleControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ScheduleProperties properties = new ScheduleProperties();
        properties.setName("Demo School");
        properties.setAcademicYear("2026/2027");

        ScheduleProperties.Schedule schedule = new ScheduleProperties.Schedule();
        schedule.setLessonDurationMinutes(45);
        schedule.setBreakDurationMinutes(10);
        properties.setSchedule(schedule);

        mockMvc = MockMvcBuilders.standaloneSetup(new ScheduleController(properties)).build();
    }

    @Test
    void returnsScheduleConfiguration() throws Exception {
        mockMvc.perform(get("/api/schedule/config"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.service").value("schedule-service"))
                .andExpect(jsonPath("$.school").value("Demo School"))
                .andExpect(jsonPath("$.academicYear").value("2026/2027"))
                .andExpect(jsonPath("$.lessonDurationMinutes").value(45))
                .andExpect(jsonPath("$.breakDurationMinutes").value(10));
    }
}
