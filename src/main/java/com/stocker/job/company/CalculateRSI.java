package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CalculateRSI implements ICalculateJob {
    public void calculate(Company company) {
        Objects.requireNonNull(company, "Company cannot be null");
        company.getDays().forEach(day -> {
            List<Day> tail = new ArrayList<>(company.getDays().headSet(day));
            Collections.reverse(tail);
            day.setFiveRSI(tail.isEmpty() ? 50 : calculateRSI(tail, 5));
            day.setTenRSI(tail.isEmpty() ? 50 : calculateRSI(tail, 10));
            day.setFifteenRSI(tail.isEmpty() ? 50 : calculateRSI(tail, 15));
            day.setTwentyRSI(tail.isEmpty() ? 50 : calculateRSI(tail, 20));
            day.setTwentyFiveRSI(tail.isEmpty() ? 50 : calculateRSI(tail, 25));
            day.setThirtyRSI(tail.isEmpty() ? 50 : calculateRSI(tail, 30));
        });
    }

    private double calculateRSI(List<Day> days, int count) {
        double gain = 0;
        double loss = 0;
        for (int i = 0; i < Math.min(count, days.size() - 1); i++) {
            gain += getDifference(days.get(i + 1).getPrice(), days.get(i).getPrice());
            gain += getDifference(days.get(i + 1).getMinPrice(), days.get(i).getMinPrice());
            gain += getDifference(days.get(i + 1).getMaxPrice(), days.get(i).getMaxPrice());

            loss += getDifference(days.get(i).getPrice(), days.get(i + 1).getPrice());
            loss += getDifference(days.get(i).getMinPrice(), days.get(i + 1).getMinPrice());
            loss += getDifference(days.get(i).getMaxPrice(), days.get(i + 1).getMaxPrice());
        }

        double rs = 1000;
        if (loss > 0) {
            rs = gain / loss;
        }
        return (100 - 100 / (1 + rs)) / 100;
    }

    private double getDifference(double biggerPrice, double lowerPrice) {
        if (biggerPrice > lowerPrice) {
            return biggerPrice - lowerPrice;
        }
        return 0.0;
    }
}
