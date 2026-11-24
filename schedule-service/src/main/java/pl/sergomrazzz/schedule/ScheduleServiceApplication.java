package pl.sergomrazzz.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ScheduleProperties.class)
public class ScheduleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleServiceApplication.class, args);
    }
}
