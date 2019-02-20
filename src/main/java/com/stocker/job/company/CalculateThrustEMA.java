package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.SortedSet;

@Component
public class CalculateThrustEMA implements ICalculateJob {
    public void calculate(Company company) {
        company.getDays().forEach(day -> {
            SortedSet<Day> prevDays = company.getDays().headSet(day);
            day.setThrustFiveEMA(calculateAverage(day, prevDays.isEmpty() ? 0 : prevDays.last().getThrustFiveEMA(), 5));
            day.setThrustThirtyEMA(calculateAverage(day, prevDays.isEmpty() ? 0 : prevDays.last().getThrustThirtyEMA(), 30));
        });
    }

    private double calculateAverage(Day day, double prevDayValue, int length) {
        return day.getThrustDirection() * 1.0d / length + prevDayValue * (length - 1) / length;
    }
}
