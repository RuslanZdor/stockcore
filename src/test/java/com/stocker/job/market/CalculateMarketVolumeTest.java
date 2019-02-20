package com.stocker.job.market;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import com.stocker.symbol.Market;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalculateMarketVolumeTest {

    private CalculateMarketVolume calculateMarketVolume;
    private List<Company> companies;

    @Before
    public void prepareObject() {
        calculateMarketVolume = new CalculateMarketVolume();

        companies = new ArrayList<>();

        Company company = new Company();
        Day day = new Day(LocalDate.now());
        day.setVolume(100);
        day.setPrice(100);
        for (int i = 0; i < 30; i++) {
            company.getDays().add(day);
        }
        companies.add(company);

        company = new Company();
        day = new Day(LocalDate.now());
        day.setVolume(200);
        day.setPrice(200);
        for (int i = 0; i < 30; i++) {
            company.getDays().add(day);
        }
        companies.add(company);
    }

    @Test
    public void testCalculateAverageVolume() {
        Market market = new Market();
    }

    @Test
    public void testCalculate() {
//        Assert.assertEquals(0, calculateMarketVolume.calculate(new ArrayList<Company>(), 5), 0.1);
    }
}