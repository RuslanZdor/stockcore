package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Set;

@Component
public class CalculateAverageVolume implements ICalculateJob {
    public void calculate(Company company) {
        company.getDays().forEach(day -> {
            Day searchDay = new Day();
            searchDay.setDate(day.getDate().minus(5, ChronoUnit.DAYS));
            day.setFiveAverageVolume(calculateVolume(company.getDays().subSet(company.getDay(searchDay), day)));
            searchDay.setDate(day.getDate().minus(10, ChronoUnit.DAYS));
            day.setTenAverageVolume(calculateVolume(company.getDays().subSet(company.getDay(searchDay), day)));
            searchDay.setDate(day.getDate().minus(15, ChronoUnit.DAYS));
            day.setFifteenAverageVolume(calculateVolume(company.getDays().subSet(company.getDay(searchDay), day)));
            searchDay.setDate(day.getDate().minus(20, ChronoUnit.DAYS));
            day.setTwentyAverageVolume(calculateVolume(company.getDays().subSet(company.getDay(searchDay), day)));
            searchDay.setDate(day.getDate().minus(25, ChronoUnit.DAYS));
            day.setTwentyFiveAverageVolume(calculateVolume(company.getDays().subSet(company.getDay(searchDay), day)));
            searchDay.setDate(day.getDate().minus(30, ChronoUnit.DAYS));
            day.setThirtyAverageVolume(calculateVolume(company.getDays().subSet(company.getDay(searchDay), day)));
        });
    }

    private double calculateVolume(Set<Day> days) {
        double results = 0;
        for (Day day : days) {
            results += day.getVolume();
        }
        return days.size() == 0 ? results : results / days.size();
    }
}
