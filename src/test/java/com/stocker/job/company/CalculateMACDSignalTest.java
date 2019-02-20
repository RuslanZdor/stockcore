package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class CalculateMACDSignalTest {

    private CalculateMACDSignal calculateMACDSignal;
    private Company company;

    @Before
    public void prepare() {
        calculateMACDSignal = new CalculateMACDSignal();
        company = new Company();
        for (int i = 1; i <= 10; i++) {
            Day day = new Day(LocalDate.now());
            day.getDate().minus(i, ChronoUnit.DAYS);
            day.setMACDLine(10.0 * i);
            company.getDays().add(day);
        }
    }

    @Test
    public void calculate() {
        calculateMACDSignal.calculate(company);
        assertEquals(1.1, company.getDays().first().getMACDSignal(), 0.1);
    }
}