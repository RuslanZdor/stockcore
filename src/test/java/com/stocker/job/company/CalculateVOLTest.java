package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class CalculateVOLTest {

    @Test
    public void calculate() {
        Company company = new Company();
        for (int i = 1; i <= 31; i++) {
            Day day = new Day(LocalDate.now().plus(i, ChronoUnit.DAYS));
            day.setPrice(i);
            company.getDays().add(day);
        }

        CalculateVOL calculateVOL = new CalculateVOL();
        calculateVOL.calculate(company);

        assertEquals(786, company.getDays().last().getFiveVOL(), 0.1);
        assertEquals(658.5, company.getDays().last().getTenVOL(), 0.1);
        assertEquals(547.6, company.getDays().last().getFifteenVOL(), 0.1);
        assertEquals(453.5, company.getDays().last().getTwentyVOL(), 0.1);
        assertEquals(376, company.getDays().last().getTwentyFiveVOL(), 0.1);
        assertEquals(315.16, company.getDays().last().getThirtyVOL(), 0.1);
    }

    @Test
    public void firstDay() {
        Company company = new Company();
        Day day = new Day(LocalDate.now());
        day.setPrice(10);
        company.getDays().add(day);

        CalculateVOL calculateVOL = new CalculateVOL();
        calculateVOL.calculate(company);

        assertEquals(0, company.getDays().last().getFiveVOL(), 0.1);
        assertEquals(0, company.getDays().last().getTenVOL(), 0.1);
        assertEquals(0, company.getDays().last().getFifteenVOL(), 0.1);
        assertEquals(0, company.getDays().last().getTwentyVOL(), 0.1);
        assertEquals(0, company.getDays().last().getTwentyFiveVOL(), 0.1);
        assertEquals(0, company.getDays().last().getThirtyVOL(), 0.1);
    }
}