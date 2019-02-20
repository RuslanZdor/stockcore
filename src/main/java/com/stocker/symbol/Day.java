package com.stocker.symbol;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * daily information
 */

@Entity
@Table(name = "company_day_statistics", schema = "stocker")
public class Day implements Comparable<Day>{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "symbol")
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;


    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private long volume;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private double minPrice;
    @Column(nullable = false)
    private double maxPrice;
    private double fiveEMA;
    private double tenEMA;
    private double fifteenEMA;
    private double twentyEMA;
    private double twentyFiveEMA;
    private double thirtyEMA;

    private double fiveSMA;
    private double tenSMA;
    private double fifteenSMA;
    private double twentySMA;
    private double twentyFiveSMA;
    private double thirtySMA;

    private double fiveRSI;
    private double tenRSI;
    private double fifteenRSI;
    private double twentyRSI;
    private double twentyFiveRSI;
    private double thirtyRSI;

    private double fiveAverageVolume;
    private double tenAverageVolume;
    private double fifteenAverageVolume;
    private double twentyAverageVolume;
    private double twentyFiveAverageVolume;
    private double thirtyAverageVolume;

    private double fiveVOL;
    private double tenVOL;
    private double fifteenVOL;
    private double twentyVOL;
    private double twentyFiveVOL;
    private double thirtyVOL;

    private double moneyVolume;
    private double fiveMVSMA;
    private double tenMVSMA;
    private double fifteenMVSMA;
    private double twentyMVSMA;
    private double twentyFiveMVSMA;
    private double thirtyMVSMA;

    private int thrustDirection;
    private double thrustFiveEMA;
    private double thrustThirtyEMA;

    private double MACDLine;
    private double MACDSignal;

    private double resistance;
    private double support;

    /**
     * calculated only for market
     */
    private double VIX;

    private boolean isRising = false;

    public Day(LocalDate date) {
        this.date = date;
    }

    /**
     * default constructor for hibernate
     */
    public Day() {

    }

    /**
     * days are equal of date are the same
     * @param obj to compare
     * @return comparison of objects
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Day) {
            Day compareDay = (Day) obj;
            if (date == null || compareDay.getDate() == null) {
                return false;
            }
            return date.equals(compareDay.getDate());
        }
        throw new ClassCastException("Object to compare can be only Day type");
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRising() {
        return isRising;
    }

    public void setRising(boolean rising) {
        isRising = rising;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getVIX() {
        return VIX;
    }

    public void setVIX(double VIX) {
        this.VIX = VIX;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getFiveEMA() {
        return fiveEMA;
    }

    public void setFiveEMA(double fiveEMA) {
        this.fiveEMA = fiveEMA;
    }

    public double getTenEMA() {
        return tenEMA;
    }

    public void setTenEMA(double tenEMA) {
        this.tenEMA = tenEMA;
    }

    public double getFifteenEMA() {
        return fifteenEMA;
    }

    public void setFifteenEMA(double fifteenEMA) {
        this.fifteenEMA = fifteenEMA;
    }

    public double getTwentyEMA() {
        return twentyEMA;
    }

    public void setTwentyEMA(double twentyEMA) {
        this.twentyEMA = twentyEMA;
    }

    public double getTwentyFiveEMA() {
        return twentyFiveEMA;
    }

    public void setTwentyFiveEMA(double twentyFiveEMA) {
        this.twentyFiveEMA = twentyFiveEMA;
    }

    public double getThirtyEMA() {
        return thirtyEMA;
    }

    public void setThirtyEMA(double thirtyEMA) {
        this.thirtyEMA = thirtyEMA;
    }

    public double getFiveSMA() {
        return fiveSMA;
    }

    public void setFiveSMA(double fiveSMA) {
        this.fiveSMA = fiveSMA;
    }

    public double getTenSMA() {
        return tenSMA;
    }

    public void setTenSMA(double tenSMA) {
        this.tenSMA = tenSMA;
    }

    public double getFifteenSMA() {
        return fifteenSMA;
    }

    public void setFifteenSMA(double fifteenSMA) {
        this.fifteenSMA = fifteenSMA;
    }

    public double getTwentySMA() {
        return twentySMA;
    }

    public void setTwentySMA(double twentySMA) {
        this.twentySMA = twentySMA;
    }

    public double getTwentyFiveSMA() {
        return twentyFiveSMA;
    }

    public void setTwentyFiveSMA(double twentyFiveSMA) {
        this.twentyFiveSMA = twentyFiveSMA;
    }

    public double getThirtySMA() {
        return thirtySMA;
    }

    public void setThirtySMA(double thirtySMA) {
        this.thirtySMA = thirtySMA;
    }

    public double getFiveRSI() {
        return fiveRSI;
    }

    public void setFiveRSI(double fiveRSI) {
        this.fiveRSI = fiveRSI;
    }

    public double getTenRSI() {
        return tenRSI;
    }

    public void setTenRSI(double tenRSI) {
        this.tenRSI = tenRSI;
    }

    public double getFifteenRSI() {
        return fifteenRSI;
    }

    public void setFifteenRSI(double fifteenRSI) {
        this.fifteenRSI = fifteenRSI;
    }

    public double getTwentyRSI() {
        return twentyRSI;
    }

    public void setTwentyRSI(double twentyRSI) {
        this.twentyRSI = twentyRSI;
    }

    public double getTwentyFiveRSI() {
        return twentyFiveRSI;
    }

    public void setTwentyFiveRSI(double twentyFiveRSI) {
        this.twentyFiveRSI = twentyFiveRSI;
    }

    public double getThirtyRSI() {
        return thirtyRSI;
    }

    public void setThirtyRSI(double thirtyRSI) {
        this.thirtyRSI = thirtyRSI;
    }

    public double getFiveAverageVolume() {
        return fiveAverageVolume;
    }

    public void setFiveAverageVolume(double fiveAverageVolume) {
        this.fiveAverageVolume = fiveAverageVolume;
    }

    public double getTenAverageVolume() {
        return tenAverageVolume;
    }

    public void setTenAverageVolume(double tenAverageVolume) {
        this.tenAverageVolume = tenAverageVolume;
    }

    public double getFifteenAverageVolume() {
        return fifteenAverageVolume;
    }

    public void setFifteenAverageVolume(double fifteenAverageVolume) {
        this.fifteenAverageVolume = fifteenAverageVolume;
    }

    public double getTwentyAverageVolume() {
        return twentyAverageVolume;
    }

    public void setTwentyAverageVolume(double twentyAverageVolume) {
        this.twentyAverageVolume = twentyAverageVolume;
    }

    public double getTwentyFiveAverageVolume() {
        return twentyFiveAverageVolume;
    }

    public void setTwentyFiveAverageVolume(double twentyFiveAverageVolume) {
        this.twentyFiveAverageVolume = twentyFiveAverageVolume;
    }

    public double getThirtyAverageVolume() {
        return thirtyAverageVolume;
    }

    public void setThirtyAverageVolume(double thirtyAverageVolume) {
        this.thirtyAverageVolume = thirtyAverageVolume;
    }

    public double getFiveVOL() {
        return fiveVOL;
    }

    public void setFiveVOL(double fiveVOL) {
        this.fiveVOL = fiveVOL;
    }

    public double getTenVOL() {
        return tenVOL;
    }

    public void setTenVOL(double tenVOL) {
        this.tenVOL = tenVOL;
    }

    public double getFifteenVOL() {
        return fifteenVOL;
    }

    public void setFifteenVOL(double fifteenVOL) {
        this.fifteenVOL = fifteenVOL;
    }

    public double getTwentyVOL() {
        return twentyVOL;
    }

    public void setTwentyVOL(double twentyVOL) {
        this.twentyVOL = twentyVOL;
    }

    public double getTwentyFiveVOL() {
        return twentyFiveVOL;
    }

    public void setTwentyFiveVOL(double twentyFiveVOL) {
        this.twentyFiveVOL = twentyFiveVOL;
    }

    public double getThirtyVOL() {
        return thirtyVOL;
    }

    public void setThirtyVOL(double thirtyVOL) {
        this.thirtyVOL = thirtyVOL;
    }

    public int getThrustDirection() {
        return thrustDirection;
    }

    public void setThrustDirection(int thrustDirection) {
        this.thrustDirection = thrustDirection;
    }

    public double getThrustFiveEMA() {
        return thrustFiveEMA;
    }

    public void setThrustFiveEMA(double thrustFiveEMA) {
        this.thrustFiveEMA = thrustFiveEMA;
    }

    public double getThrustThirtyEMA() {
        return thrustThirtyEMA;
    }

    public void setThrustThirtyEMA(double thrustThirtyEMA) {
        this.thrustThirtyEMA = thrustThirtyEMA;
    }

    public double getMACDLine() {
        return MACDLine;
    }

    public void setMACDLine(double MACDLine) {
        this.MACDLine = MACDLine;
    }

    public double getMACDSignal() {
        return MACDSignal;
    }

    public void setMACDSignal(double MACDSignal) {
        this.MACDSignal = MACDSignal;
    }

    public double getMoneyVolume() {
        return moneyVolume;
    }

    public void setMoneyVolume(double moneyVolume) {
        this.moneyVolume = moneyVolume;
    }

    public double getFiveMVSMA() {
        return fiveMVSMA;
    }

    public void setFiveMVSMA(double fiveMVSMA) {
        this.fiveMVSMA = fiveMVSMA;
    }

    public double getTenMVSMA() {
        return tenMVSMA;
    }

    public void setTenMVSMA(double tenMVSMA) {
        this.tenMVSMA = tenMVSMA;
    }

    public double getFifteenMVSMA() {
        return fifteenMVSMA;
    }

    public void setFifteenMVSMA(double fifteenMVSMA) {
        this.fifteenMVSMA = fifteenMVSMA;
    }

    public double getTwentyMVSMA() {
        return twentyMVSMA;
    }

    public void setTwentyMVSMA(double twentyMVSMA) {
        this.twentyMVSMA = twentyMVSMA;
    }

    public double getTwentyFiveMVSMA() {
        return twentyFiveMVSMA;
    }

    public void setTwentyFiveMVSMA(double twentyFiveMVSMA) {
        this.twentyFiveMVSMA = twentyFiveMVSMA;
    }

    public double getThirtyMVSMA() {
        return thirtyMVSMA;
    }

    public void setThirtyMVSMA(double thirtyMVSMA) {
        this.thirtyMVSMA = thirtyMVSMA;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public double getSupport() {
        return support;
    }

    public void setSupport(double support) {
        this.support = support;
    }

    @Override
    public int compareTo(Day d2) {
        if(getDate() == d2.getDate()){
            return 0;
        }
        return getDate().compareTo(d2.getDate());
    }
}
