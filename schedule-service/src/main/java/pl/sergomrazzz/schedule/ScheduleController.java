package pl.sergomrazzz.schedule;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
@RefreshScope
public class ScheduleController {

    private final ScheduleProperties properties;

    public ScheduleController(ScheduleProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/config")
    public ScheduleConfigResponse getConfiguration() {
        ScheduleProperties.Schedule schedule = properties.getSchedule();
        return new ScheduleConfigResponse(
                "schedule-service",
                properties.getName(),
                properties.getAcademicYear(),
                schedule.getLessonDurationMinutes(),
                schedule.getBreakDurationMinutes()
        );
    }

    public record ScheduleConfigResponse(
            String service,
            String school,
            String academicYear,
            Integer lessonDurationMinutes,
            Integer breakDurationMinutes
    ) {
    }
}
