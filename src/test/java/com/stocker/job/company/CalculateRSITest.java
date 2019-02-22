package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.Assert.*;

public class CalculateRSITest {

    @Test
    public void calculateEmpty() {
        Company company = new Company();
        CalculateRSI calculate= new CalculateRSI();
        Day day = new Day(LocalDate.now());
        day.setPrice(10);
        company.getDays().add(day);
        calculate.calculate(company);

        assertEquals(50, company.getDays().first().getFiveRSI(), 0.1);
        assertEquals(50, company.getDays().first().getTenRSI(), 0.1);
        assertEquals(50, company.getDays().first().getFifteenRSI(), 0.1);
        assertEquals(50, company.getDays().first().getTwentyRSI(), 0.1);
        assertEquals(50, company.getDays().first().getTwentyFiveRSI(), 0.1);
        assertEquals(50, company.getDays().first().getThirtyRSI(), 0.1);
    }

    @Test
    public void calculate() {
        Company company = new Company();
        for (int i = 1; i <= 30; i++) {
            Day day = new Day(LocalDate.now().minus(i, ChronoUnit.DAYS));
            day.setPrice(i);
            day.setMinPrice(i - 1);
            day.setMaxPrice(i + 1);
            company.getDays().add(day);
        }

        CalculateRSI calculate= new CalculateRSI();
        calculate.calculate(company);

        assertEquals(0.99, company.getDays().last().getFiveRSI(), 0.1);
        assertEquals(0.99, company.getDays().last().getTenRSI(), 0.1);
        assertEquals(0.99, company.getDays().last().getFifteenRSI(), 0.1);
        assertEquals(0.99, company.getDays().last().getTwentyRSI(), 0.1);
        assertEquals(0.99, company.getDays().last().getTwentyFiveRSI(), 0.1);
        assertEquals(0.99, company.getDays().last().getThirtyRSI(), 0.1);
    }
}