package com.stocker.symbol.tensorflow;

import com.stocker.symbol.Company;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * daily information transformed for tensorflow
 */
@Entity
@Table(name = "tensorflow_day_statistics", schema = "stocker")
public class TensorFlowDay {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @JoinColumn(name="symbol")
    @ManyToOne(cascade= CascadeType.ALL)
    private Company company;

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

    private double thrustFiveEMA;
    private double thrustThirtyEMA;

    private double MACDLine;
    private double MACDSignal;

    private double resistance;
    private double support;

    private double minPrice;
    private double maxPrice;

    private double VIX;

    private double fiveMarketAverageVolume;
    private double tenMarketAverageVolume;
    private double fifteenMarketAverageVolume;
    private double twentyMarketAverageVolume;
    private double twentyFiveMarketAverageVolume;
    private double thirtyMarketAverageVolume;

    private double fiveMarketMoneyVolume;
    private double tenMarketMoneyVolume;
    private double fifteenMarketMoneyVolume;
    private double twentyMarketMoneyVolume;
    private double twentyMarketFiveMoneyVolume;
    private double thirtyMarketMoneyVolume;

    private LocalDate date;

    private double dayDifference;

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

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getVIX() {
        return VIX;
    }

    public void setVIX(double VIX) {
        this.VIX = VIX;
    }

    public double getFiveMarketAverageVolume() {
        return fiveMarketAverageVolume;
    }

    public void setFiveMarketAverageVolume(double fiveMarketAverageVolume) {
        this.fiveMarketAverageVolume = fiveMarketAverageVolume;
    }

    public double getTenMarketAverageVolume() {
        return tenMarketAverageVolume;
    }

    public void setTenMarketAverageVolume(double tenMarketAverageVolume) {
        this.tenMarketAverageVolume = tenMarketAverageVolume;
    }

    public double getFifteenMarketAverageVolume() {
        return fifteenMarketAverageVolume;
    }

    public void setFifteenMarketAverageVolume(double fifteenMarketAverageVolume) {
        this.fifteenMarketAverageVolume = fifteenMarketAverageVolume;
    }

    public double getTwentyMarketAverageVolume() {
        return twentyMarketAverageVolume;
    }

    public void setTwentyMarketAverageVolume(double twentyMarketAverageVolume) {
        this.twentyMarketAverageVolume = twentyMarketAverageVolume;
    }

    public double getThirtyMarketAverageVolume() {
        return thirtyMarketAverageVolume;
    }

    public void setThirtyMarketAverageVolume(double thirtyMarketAverageVolume) {
        this.thirtyMarketAverageVolume = thirtyMarketAverageVolume;
    }

    public double getFiveMarketMoneyVolume() {
        return fiveMarketMoneyVolume;
    }

    public void setFiveMarketMoneyVolume(double fiveMarketMoneyVolume) {
        this.fiveMarketMoneyVolume = fiveMarketMoneyVolume;
    }

    public double getTenMarketMoneyVolume() {
        return tenMarketMoneyVolume;
    }

    public void setTenMarketMoneyVolume(double tenMarketMoneyVolume) {
        this.tenMarketMoneyVolume = tenMarketMoneyVolume;
    }

    public double getFifteenMarketMoneyVolume() {
        return fifteenMarketMoneyVolume;
    }

    public void setFifteenMarketMoneyVolume(double fifteenMarketMoneyVolume) {
        this.fifteenMarketMoneyVolume = fifteenMarketMoneyVolume;
    }

    public double getTwentyMarketMoneyVolume() {
        return twentyMarketMoneyVolume;
    }

    public void setTwentyMarketMoneyVolume(double twentyMarketMoneyVolume) {
        this.twentyMarketMoneyVolume = twentyMarketMoneyVolume;
    }

    public double getTwentyMarketFiveMoneyVolume() {
        return twentyMarketFiveMoneyVolume;
    }

    public void setTwentyMarketFiveMoneyVolume(double twentyMarketFiveMoneyVolume) {
        this.twentyMarketFiveMoneyVolume = twentyMarketFiveMoneyVolume;
    }

    public double getThirtyMarketMoneyVolume() {
        return thirtyMarketMoneyVolume;
    }

    public void setThirtyMarketMoneyVolume(double thirtyMarketMoneyVolume) {
        this.thirtyMarketMoneyVolume = thirtyMarketMoneyVolume;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getTwentyFiveMarketAverageVolume() {
        return twentyFiveMarketAverageVolume;
    }

    public void setTwentyFiveMarketAverageVolume(double twentyFiveMarketAverageVolume) {
        this.twentyFiveMarketAverageVolume = twentyFiveMarketAverageVolume;
    }

    public double getDayDifference() {
        return dayDifference;
    }

    public void setDayDifference(double dayDifference) {
        this.dayDifference = dayDifference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
