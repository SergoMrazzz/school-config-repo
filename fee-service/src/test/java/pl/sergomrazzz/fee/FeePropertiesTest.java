package pl.sergomrazzz.fee;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class FeePropertiesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(PropertiesConfiguration.class)
            .withPropertyValues(
                    "school.name=Demo School",
                    "school.academic-year=2026/2027",
                    "school.fees.lunch-price=15.00",
                    "school.fees.extracurricular-fee=100.00",
                    "school.fees.currency=PLN"
            );

    @Test
    void bindsSharedAndFeeConfiguration() {
        contextRunner.run(context -> {
            assertThat(context).hasNotFailed();
            FeeProperties properties = context.getBean(FeeProperties.class);
            assertThat(properties.getName()).isEqualTo("Demo School");
            assertThat(properties.getAcademicYear()).isEqualTo("2026/2027");
            assertThat(properties.getFees().getLunchPrice()).isEqualTo(new BigDecimal("15.00"));
            assertThat(properties.getFees().getExtracurricularFee()).isEqualTo(new BigDecimal("100.00"));
            assertThat(properties.getFees().getCurrency()).isEqualTo("PLN");
        });
    }

    @Configuration(proxyBeanMethods = false)
    @EnableConfigurationProperties(FeeProperties.class)
    static class PropertiesConfiguration {
    }
}
