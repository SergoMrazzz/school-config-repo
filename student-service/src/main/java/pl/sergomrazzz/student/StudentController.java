package pl.sergomrazzz.student;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@RefreshScope
public class StudentController {

    private final StudentProperties properties;

    public StudentController(StudentProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/config")
    public StudentConfigResponse getConfiguration() {
        StudentProperties.Students students = properties.getStudents();
        return new StudentConfigResponse(
                "student-service",
                properties.getName(),
                properties.getAcademicYear(),
                students.getMinimumAge(),
                students.getMaximumClassSize()
        );
    }

    public record StudentConfigResponse(
            String service,
            String school,
            String academicYear,
            Integer minimumAge,
            Integer maximumClassSize
    ) {
    }
}
