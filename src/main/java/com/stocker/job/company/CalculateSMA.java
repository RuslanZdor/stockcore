package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Calculate simple muving average for company/market/industry
 */
@Component
public class CalculateSMA implements ICalculateJob {
    public void calculate(Company company) {
        for (Day day : company.getDays()) {
            SortedSet<Day> tail = company.getDays().headSet(day);
            day.setFiveSMA(tail.isEmpty() ? day.getPrice() : calculateAverage(tail, 5));
            day.setTenSMA(tail.isEmpty() ? day.getPrice() : calculateAverage(tail, 10));
            day.setFifteenSMA(tail.isEmpty() ? day.getPrice() : calculateAverage(tail, 15));
            day.setTwentySMA(tail.isEmpty() ? day.getPrice() : calculateAverage(tail, 20));
            day.setTwentyFiveSMA(tail.isEmpty() ? day.getPrice() : calculateAverage(tail, 25));
            day.setThirtySMA(tail.isEmpty() ? day.getPrice() : calculateAverage(tail, 30));
        }
    }

    private double calculateAverage(SortedSet<Day> days, int size) {
        double results = 0;
        List<Day> listOfDays = new ArrayList<>(days);
        Collections.reverse(listOfDays);
        for (int i = 0; i < Math.min(size, days.size()); i++) {
            results += listOfDays.get(i).getPrice();
        }
        return results / Math.min(size, days.size());
    }
}
