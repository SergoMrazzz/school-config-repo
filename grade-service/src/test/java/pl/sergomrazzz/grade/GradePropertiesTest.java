package pl.sergomrazzz.grade;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class GradePropertiesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(PropertiesConfiguration.class)
            .withPropertyValues(
                    "school.name=Demo School",
                    "school.academic-year=2026/2027",
                    "school.grades.minimum-passing-grade=2",
                    "school.grades.exam-weight=0.40"
            );

    @Test
    void bindsSharedAndGradeConfiguration() {
        contextRunner.run(context -> {
            assertThat(context).hasNotFailed();
            GradeProperties properties = context.getBean(GradeProperties.class);
            assertThat(properties.getName()).isEqualTo("Demo School");
            assertThat(properties.getAcademicYear()).isEqualTo("2026/2027");
            assertThat(properties.getGrades().getMinimumPassingGrade()).isEqualTo(2);
            assertThat(properties.getGrades().getExamWeight()).isEqualTo(new BigDecimal("0.40"));
        });
    }

    @Configuration(proxyBeanMethods = false)
    @EnableConfigurationProperties(GradeProperties.class)
    static class PropertiesConfiguration {
    }
}
