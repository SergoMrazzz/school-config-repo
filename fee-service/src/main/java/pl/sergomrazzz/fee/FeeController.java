package pl.sergomrazzz.fee;

import java.math.BigDecimal;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fees")
@RefreshScope
public class FeeController {

    private final FeeProperties properties;

    public FeeController(FeeProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/config")
    public FeeConfigResponse getConfiguration() {
        FeeProperties.Fees fees = properties.getFees();
        return new FeeConfigResponse(
                "fee-service",
                properties.getName(),
                properties.getAcademicYear(),
                fees.getLunchPrice(),
                fees.getExtracurricularFee(),
                fees.getCurrency()
        );
    }

    public record FeeConfigResponse(
            String service,
            String school,
            String academicYear,
            BigDecimal lunchPrice,
            BigDecimal extracurricularFee,
            String currency
    ) {
    }
}
