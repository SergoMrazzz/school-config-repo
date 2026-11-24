package pl.sergomrazzz.fee;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "school")
public class FeeProperties {

    private String name;
    private String academicYear;
    private Fees fees = new Fees();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    public static class Fees {

        private BigDecimal lunchPrice;
        private BigDecimal extracurricularFee;
        private String currency;

        public BigDecimal getLunchPrice() {
            return lunchPrice;
        }

        public void setLunchPrice(BigDecimal lunchPrice) {
            this.lunchPrice = lunchPrice;
        }

        public BigDecimal getExtracurricularFee() {
            return extracurricularFee;
        }

        public void setExtracurricularFee(BigDecimal extracurricularFee) {
            this.extracurricularFee = extracurricularFee;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
