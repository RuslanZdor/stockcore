package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateMACDLineTest {

    private CalculateMACDLine calculateMACDLine;
    private Company company;

    @Before
    public void prepare() {
        calculateMACDLine = new CalculateMACDLine();
        company = new Company();
        Day day = new Day();
        day.setTenEMA(10);
        day.setTwentyFiveEMA(20);
        company.getDays().add(day);
    }

    @Test
    public void calculate() {
        calculateMACDLine.calculate(company);
        assertEquals("Calculate MACD", 0.5, company.getDays().last().getMACDLine(), 0);
    }
}