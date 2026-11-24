package pl.sergomrazzz.grade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GradeProperties.class)
public class GradeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradeServiceApplication.class, args);
    }
}
