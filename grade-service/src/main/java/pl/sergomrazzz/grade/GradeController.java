package pl.sergomrazzz.grade;

import java.math.BigDecimal;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grades")
@RefreshScope
public class GradeController {

    private final GradeProperties properties;

    public GradeController(GradeProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/config")
    public GradeConfigResponse getConfiguration() {
        GradeProperties.Grades grades = properties.getGrades();
        return new GradeConfigResponse(
                "grade-service",
                properties.getName(),
                properties.getAcademicYear(),
                grades.getMinimumPassingGrade(),
                grades.getExamWeight()
        );
    }

    public record GradeConfigResponse(
            String service,
            String school,
            String academicYear,
            Integer minimumPassingGrade,
            BigDecimal examWeight
    ) {
    }
}
