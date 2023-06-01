package com.mkpits.trading.h2db.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trading_data")
public class TradingDataH2Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scripe_id")
    private long id;

    @Column(name ="fifty_weeks_high")
    private double fiftyWeeksHigh;

    @Column(name ="fifty_weeks_low")
    private double fiftyWeeksLow;

    @Column(name ="scripe_name")
    private String scripeName;

    @Column(name ="current_price")
    private double currentPrice;
}
