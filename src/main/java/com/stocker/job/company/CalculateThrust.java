package com.stocker.job.company;

import com.stocker.symbol.Company;
import com.stocker.symbol.Day;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.SortedSet;

@Component
public class CalculateThrust implements ICalculateJob {
    public void calculate(Company company) {
        company.getDays().forEach((Day day) -> {
            SortedSet<Day> prevDays = company.getDays().tailSet(day);
            if (!prevDays.isEmpty()) {
                day.setThrustDirection(calculateThrust(day, Objects.requireNonNull(prevDays.first())));
            }
        });
    }

    private static int calculateThrust(Day day, Day prevDay) {
        if (day.getPrice() > prevDay.getMaxPrice()) {
            return 1;
        }
        if (day.getPrice() < prevDay.getMinPrice()) {
            return -1;
        }
        return 0;
    }
}
