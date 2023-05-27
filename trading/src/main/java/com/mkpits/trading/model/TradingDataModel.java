package com.mkpits.trading.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TradingDataModel {
    @Id
    private long id;

    private double fiftyWeeksHigh;

    private double fiftyWeeksLow;

    private String scripeName;

    private double currentPrice;
}
