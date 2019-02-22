package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

@Component
public class CalculateVOL implements ICalculateJob {
    public void calculate(Company company) {
        company.getDays().forEach(day -> {
            day.setFiveVOL(calculateVOL(company.getDays().headSet(day),5, day.getFiveSMA()));
            day.setTenVOL(calculateVOL(company.getDays().headSet(day), 10, day.getTenSMA()));
            day.setFifteenVOL(calculateVOL(company.getDays().headSet(day), 15, day.getFifteenSMA()));
            day.setTwentyVOL(calculateVOL(company.getDays().headSet(day), 20, day.getTwentySMA()));
            day.setTwentyFiveVOL(calculateVOL(company.getDays().headSet(day), 25, day.getTwentyFiveSMA()));
            day.setThirtyVOL(calculateVOL(company.getDays().headSet(day), 30, day.getThirtySMA()));
        });
    }

    private double calculateVOL(SortedSet<Day> days, int length, double average) {
        double results = 0;
        List<Day> listOfDays = new ArrayList<>(days);
        Collections.reverse(listOfDays);
        for (int i = 0; i < Math.min(length, days.size()); i++) {
            results += Math.pow(listOfDays.get(i).getPrice() - average, 2);
        }
        return results / length;
    }
}
