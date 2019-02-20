package com.stocker.symbol;

import com.stocker.symbol.tensorflow.TensorFlowDay;

import javax.persistence.*;
import java.util.*;

/**
 * company information
 */

@Entity
@Table(name="company", schema = "stocker")
public class Company {

    @Id
    @Column(name="symbol", unique = true)
    private String symbol;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String industry;

    /**
     * daily information
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
    @OrderBy("date ASC")
    private SortedSet<Day> days = new TreeSet<>();

    /**
     * daily information transformed for tensorflow
     */
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @OrderBy("date ASC")
    private SortedSet<TensorFlowDay> tensorFlowDay;

    public String getSymbol() {
        return symbol;
    }

    /**
     * return day with the same date as in parameter
     * or new day with this date will be created and added to list
     * @param day for search
     * @return founded or created day
     */
    public Day getDay(Day day) {
        Object[] foundDays = days.stream().filter(fDay -> fDay.getDate().equals(day.getDate())).toArray();
        if (foundDays.length > 0) {
            return (Day) foundDays[0];
        }
        return getDays().first();
    }

    /**
     * find max daily volume for this company
     * @return max volume
     */
    public long getMaxDayVolume() {
        long maxVolume = 0;
        for (Day day : getDays()) {
            if (maxVolume < day.getVolume()) {
                maxVolume = day.getVolume();
            }
        }
        return maxVolume;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public SortedSet<Day> getDays() {
        return days;
    }

    public void setDays(SortedSet<Day> days) {
        this.days = days;
    }

    public SortedSet<TensorFlowDay> getTensorFlowDay() {
        return tensorFlowDay;
    }

    public void setTensorFlowDay(SortedSet<TensorFlowDay> tensorFlowDay) {
        this.tensorFlowDay = tensorFlowDay;
    }
}
