package pl.sergomrazzz.fee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FeeProperties.class)
public class FeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeeServiceApplication.class, args);
    }
}
