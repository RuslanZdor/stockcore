package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class CalculateAverageVolumeTest {

    private CalculateAverageVolume calculateAverageVolume;
    private Company company;

    @Before
    public void prepare() {
        calculateAverageVolume = new CalculateAverageVolume();
        company = new Company();
        for (int i = 0; i < 31; i++) {
            Day day = new Day(LocalDate.now().minus(i, ChronoUnit.DAYS));
            day.setVolume(10 * i);
            company.getDays().add(day);
        }
    }

    @Test
    public void calculate() {
        calculateAverageVolume.calculate(company);
        assertEquals("Calculate five days volume", 30, company.getDays().last().getFiveAverageVolume(), 0);
        assertEquals("Calculate ten days volume", 55, company.getDays().last().getTenAverageVolume(), 0);
        assertEquals("Calculate fifteen days volume", 80, company.getDays().last().getFifteenAverageVolume(), 0);
        assertEquals("Calculate twenty days volume", 105, company.getDays().last().getTwentyAverageVolume(), 0);
        assertEquals("Calculate twenty five days volume", 130, company.getDays().last().getTwentyFiveAverageVolume(), 0);
        assertEquals("Calculate thirty days volume", 155, company.getDays().last().getThirtyAverageVolume(), 0);
    }
}