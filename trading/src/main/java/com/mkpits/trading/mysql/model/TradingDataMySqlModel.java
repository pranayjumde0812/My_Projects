package com.mkpits.trading.mysql.model;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TradingData")
public class TradingDataMySqlModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScripeId")
    private long id;

    @Column(name ="FiftyWeeksHigh")
    private double fiftyWeeksHigh;

    @Column(name ="FiftyWeeksLow")
    private double fiftyWeeksLow;

    @Column(name ="ScripeName")
    private String scripeName;

    @Column(name ="CurrentPrice")
    private double currentPrice;
}