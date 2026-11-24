package pl.sergomrazzz.attendance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class AttendancePropertiesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(PropertiesConfiguration.class)
            .withPropertyValues(
                    "school.name=Demo School",
                    "school.academic-year=2026/2027",
                    "school.attendance.minimum-percentage=80",
                    "school.attendance.maximum-late-arrivals=3"
            );

    @Test
    void bindsValuesFromConfigurationProperties() {
        contextRunner.run(context -> {
            assertThat(context).hasNotFailed();
            AttendanceProperties properties = context.getBean(AttendanceProperties.class);
            assertThat(properties.getName()).isEqualTo("Demo School");
            assertThat(properties.getAcademicYear()).isEqualTo("2026/2027");
            assertThat(properties.getAttendance().getMinimumPercentage()).isEqualTo(80);
            assertThat(properties.getAttendance().getMaximumLateArrivals()).isEqualTo(3);
        });
    }

    @Configuration(proxyBeanMethods = false)
    @EnableConfigurationProperties(AttendanceProperties.class)
    static class PropertiesConfiguration {
    }
}
