package pl.sergomrazzz.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class SchedulePropertiesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(PropertiesConfiguration.class)
            .withPropertyValues(
                    "school.name=Demo School",
                    "school.academic-year=2026/2027",
                    "school.schedule.lesson-duration-minutes=45",
                    "school.schedule.break-duration-minutes=10"
            );

    @Test
    void bindsSharedAndScheduleConfiguration() {
        contextRunner.run(context -> {
            assertThat(context).hasNotFailed();
            ScheduleProperties properties = context.getBean(ScheduleProperties.class);
            assertThat(properties.getName()).isEqualTo("Demo School");
            assertThat(properties.getAcademicYear()).isEqualTo("2026/2027");
            assertThat(properties.getSchedule().getLessonDurationMinutes()).isEqualTo(45);
            assertThat(properties.getSchedule().getBreakDurationMinutes()).isEqualTo(10);
        });
    }

    @Configuration(proxyBeanMethods = false)
    @EnableConfigurationProperties(ScheduleProperties.class)
    static class PropertiesConfiguration {
    }
}
