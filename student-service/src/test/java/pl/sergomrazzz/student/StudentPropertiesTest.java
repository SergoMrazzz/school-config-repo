package pl.sergomrazzz.student;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class StudentPropertiesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(PropertiesConfiguration.class)
            .withPropertyValues(
                    "school.name=Demo School",
                    "school.academic-year=2026/2027",
                    "school.students.minimum-age=6",
                    "school.students.maximum-class-size=30"
            );

    @Test
    void bindsSharedAndStudentConfiguration() {
        contextRunner.run(context -> {
            assertThat(context).hasNotFailed();
            StudentProperties properties = context.getBean(StudentProperties.class);
            assertThat(properties.getName()).isEqualTo("Demo School");
            assertThat(properties.getAcademicYear()).isEqualTo("2026/2027");
            assertThat(properties.getStudents().getMinimumAge()).isEqualTo(6);
            assertThat(properties.getStudents().getMaximumClassSize()).isEqualTo(30);
        });
    }

    @Configuration(proxyBeanMethods = false)
    @EnableConfigurationProperties(StudentProperties.class)
    static class PropertiesConfiguration {
    }
}
