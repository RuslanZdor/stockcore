package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.SortedSet;

@Component
public class CalculateEMA implements ICalculateJob {
    public void calculate(Company company) {
        company.getDays().forEach(day -> {
            SortedSet<Day> prevDays = company.getDays().headSet(day);
            day.setFiveEMA(calculateAverage(day, prevDays.isEmpty() ? day.getPrice() : prevDays.last().getFiveEMA(), 5));
            day.setTenEMA(calculateAverage(day, prevDays.isEmpty() ? day.getPrice() : prevDays.last().getTenEMA(), 10));
            day.setFifteenEMA(calculateAverage(day, prevDays.isEmpty() ? day.getPrice() : prevDays.last().getFifteenEMA(), 15));
            day.setTwentyEMA(calculateAverage(day, prevDays.isEmpty() ? day.getPrice() : prevDays.last().getTwentyEMA(), 20));
            day.setTwentyFiveEMA(calculateAverage(day, prevDays.isEmpty() ? day.getPrice() : prevDays.last().getTwentyFiveEMA(), 25));
            day.setThirtyEMA(calculateAverage(day, prevDays.isEmpty() ? day.getPrice() : prevDays.last().getThirtyEMA(), 30));
        });
    }

    protected static double calculateAverage(Day day, double prevDayValue, int length) {
        if (prevDayValue < 0) {
            return day.getPrice();
        }
        return day.getPrice() * 1 / length + prevDayValue * (length - 1) / length;
    }
}
