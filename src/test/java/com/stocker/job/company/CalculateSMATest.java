package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.Assert.*;

public class CalculateSMATest {

    @Test
    public void calculate() {
        Company company = new Company();
        for (int i = 1; i <= 31; i++) {
            Day day = new Day(LocalDate.now().plus(i, ChronoUnit.DAYS));
            day.setPrice(i);
            company.getDays().add(day);
        }

        CalculateSMA calculateSMA = new CalculateSMA();
        calculateSMA.calculate(company);

        assertEquals(28, company.getDays().last().getFiveSMA(), 0.1);
        assertEquals(25.5, company.getDays().last().getTenSMA(), 0.1);
        assertEquals(23, company.getDays().last().getFifteenSMA(), 0.1);
        assertEquals(20.5, company.getDays().last().getTwentySMA(), 0.1);
        assertEquals(18, company.getDays().last().getTwentyFiveSMA(), 0.1);
        assertEquals(15.5, company.getDays().last().getThirtySMA(), 0.1);
    }

    @Test
    public void firstDay() {
        Company company = new Company();
        Day day = new Day(LocalDate.now());
        day.setPrice(10);
        company.getDays().add(day);

        CalculateSMA calculateSMA = new CalculateSMA();
        calculateSMA.calculate(company);

        assertEquals(10, company.getDays().last().getFiveSMA(), 0.1);
        assertEquals(10, company.getDays().last().getTenSMA(), 0.1);
        assertEquals(10, company.getDays().last().getFifteenSMA(), 0.1);
        assertEquals(10, company.getDays().last().getTwentySMA(), 0.1);
        assertEquals(10, company.getDays().last().getTwentyFiveSMA(), 0.1);
        assertEquals(10, company.getDays().last().getThirtySMA(), 0.1);
    }
}