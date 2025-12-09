// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     LoanCalculatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.loanpaymentcalculator.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static LoanCalculatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(LoanCalculatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(LoanCalculatorData.class);
        writer = mapper.writerFor(LoanCalculatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// LoanCalculatorData.java

package com.apiverve.loanpaymentcalculator.data;

import com.fasterxml.jackson.annotation.*;

public class LoanCalculatorData {
    private long loanAmount;
    private long downpayment;
    private double interestRate;
    private long loanTerm;
    private double monthlyPayment;
    private double totalInterestPaid;
    private AmortizationSchedule[] amortizationSchedule;

    @JsonProperty("loanAmount")
    public long getLoanAmount() { return loanAmount; }
    @JsonProperty("loanAmount")
    public void setLoanAmount(long value) { this.loanAmount = value; }

    @JsonProperty("downpayment")
    public long getDownpayment() { return downpayment; }
    @JsonProperty("downpayment")
    public void setDownpayment(long value) { this.downpayment = value; }

    @JsonProperty("interestRate")
    public double getInterestRate() { return interestRate; }
    @JsonProperty("interestRate")
    public void setInterestRate(double value) { this.interestRate = value; }

    @JsonProperty("loanTerm")
    public long getLoanTerm() { return loanTerm; }
    @JsonProperty("loanTerm")
    public void setLoanTerm(long value) { this.loanTerm = value; }

    @JsonProperty("monthly_payment")
    public double getMonthlyPayment() { return monthlyPayment; }
    @JsonProperty("monthly_payment")
    public void setMonthlyPayment(double value) { this.monthlyPayment = value; }

    @JsonProperty("total_interest_paid")
    public double getTotalInterestPaid() { return totalInterestPaid; }
    @JsonProperty("total_interest_paid")
    public void setTotalInterestPaid(double value) { this.totalInterestPaid = value; }

    @JsonProperty("amortization_schedule")
    public AmortizationSchedule[] getAmortizationSchedule() { return amortizationSchedule; }
    @JsonProperty("amortization_schedule")
    public void setAmortizationSchedule(AmortizationSchedule[] value) { this.amortizationSchedule = value; }
}

// AmortizationSchedule.java

package com.apiverve.loanpaymentcalculator.data;

import com.fasterxml.jackson.annotation.*;

public class AmortizationSchedule {
    private long month;
    private double interestPayment;
    private double principalPayment;
    private double remainingBalance;

    @JsonProperty("month")
    public long getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(long value) { this.month = value; }

    @JsonProperty("interest_payment")
    public double getInterestPayment() { return interestPayment; }
    @JsonProperty("interest_payment")
    public void setInterestPayment(double value) { this.interestPayment = value; }

    @JsonProperty("principal_payment")
    public double getPrincipalPayment() { return principalPayment; }
    @JsonProperty("principal_payment")
    public void setPrincipalPayment(double value) { this.principalPayment = value; }

    @JsonProperty("remaining_balance")
    public double getRemainingBalance() { return remainingBalance; }
    @JsonProperty("remaining_balance")
    public void setRemainingBalance(double value) { this.remainingBalance = value; }
}