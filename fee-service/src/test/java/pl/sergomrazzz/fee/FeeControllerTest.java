package pl.sergomrazzz.fee;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FeeControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        FeeProperties properties = new FeeProperties();
        properties.setName("Demo School");
        properties.setAcademicYear("2026/2027");

        FeeProperties.Fees fees = new FeeProperties.Fees();
        fees.setLunchPrice(new BigDecimal("15.00"));
        fees.setExtracurricularFee(new BigDecimal("100.00"));
        fees.setCurrency("PLN");
        properties.setFees(fees);

        mockMvc = MockMvcBuilders.standaloneSetup(new FeeController(properties)).build();
    }

    @Test
    void returnsFeeConfiguration() throws Exception {
        mockMvc.perform(get("/api/fees/config"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.service").value("fee-service"))
                .andExpect(jsonPath("$.school").value("Demo School"))
                .andExpect(jsonPath("$.academicYear").value("2026/2027"))
                .andExpect(jsonPath("$.lunchPrice").value(15.00))
                .andExpect(jsonPath("$.extracurricularFee").value(100.00))
                .andExpect(jsonPath("$.currency").value("PLN"));
    }
}
