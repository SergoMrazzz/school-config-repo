package pl.sergomrazzz.attendance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AttendanceControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        AttendanceProperties properties = new AttendanceProperties();
        properties.setName("Demo School");
        properties.setAcademicYear("2026/2027");

        AttendanceProperties.Attendance attendance = new AttendanceProperties.Attendance();
        attendance.setMinimumPercentage(80);
        attendance.setMaximumLateArrivals(3);
        properties.setAttendance(attendance);

        mockMvc = MockMvcBuilders.standaloneSetup(new AttendanceController(properties)).build();
    }

    @Test
    void returnsAttendanceConfiguration() throws Exception {
        mockMvc.perform(get("/api/attendance/config"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.service").value("attendance-service"))
                .andExpect(jsonPath("$.school").value("Demo School"))
                .andExpect(jsonPath("$.academicYear").value("2026/2027"))
                .andExpect(jsonPath("$.minimumPercentage").value(80))
                .andExpect(jsonPath("$.maximumLateArrivals").value(3));
    }
}
