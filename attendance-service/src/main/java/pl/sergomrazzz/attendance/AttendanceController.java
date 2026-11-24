package pl.sergomrazzz.attendance;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendance")
@RefreshScope
public class AttendanceController {

    private final AttendanceProperties properties;

    public AttendanceController(AttendanceProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/config")
    public AttendanceConfigResponse getConfiguration() {
        AttendanceProperties.Attendance attendance = properties.getAttendance();
        return new AttendanceConfigResponse(
                "attendance-service",
                properties.getName(),
                properties.getAcademicYear(),
                attendance.getMinimumPercentage(),
                attendance.getMaximumLateArrivals()
        );
    }

    public record AttendanceConfigResponse(
            String service,
            String school,
            String academicYear,
            Integer minimumPercentage,
            Integer maximumLateArrivals
    ) {
    }
}
