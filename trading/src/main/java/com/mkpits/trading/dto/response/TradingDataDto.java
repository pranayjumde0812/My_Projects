package com.mkpits.trading.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TradingDataDto {

    private long id;

    private double fiftyWeeksHigh;

    private double fiftyWeeksLow;

    private String scripeName;

    private double currentPrice;
}
