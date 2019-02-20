package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CalculateRSI implements ICalculateJob {
    public void calculate(Company company) {
        company.getDays().forEach(day -> {
            day.setFiveRSI(0);
            day.setTenRSI(0);
            day.setFifteenRSI(0);
            day.setTwentyRSI(0);
            day.setTwentyFiveRSI(0);
            day.setThirtyRSI(0);
        });
    }

//    private double calculateRSI(Set<Day> days) {
//        double gain = 0;
//        double loss = 0;
//        for (Day day : days) {
//            gain += getDifference(list.get(i).getPrice(), list.get(i + 1).getPrice());
//            loss += getDifference(list.get(i + 1).getPrice(), list.get(i).getPrice());
//
//            gain += getDifference(list.get(i).getMinPrice(), list.get(i + 1).getMinPrice());
//            loss += getDifference(list.get(i + 1).getMinPrice(), list.get(i).getMinPrice());
//
//            gain += getDifference(list.get(i).getMaxPrice(), list.get(i + 1).getMaxPrice());
//            loss += getDifference(list.get(i + 1).getMaxPrice(), list.get(i).getMaxPrice());
//        }
//
//        double rs = 1000;
//        if (loss > 0) {
//            rs = gain / loss;
//        }
//        return (100 - 100 / (1 + rs)) / 100;
//    }
//
//    private double getDifference(double biggerPrice, double lowerPrice) {
//        if (biggerPrice > lowerPrice) {
//            return biggerPrice - lowerPrice;
//        }
//        return 0.0;
//    }
}
