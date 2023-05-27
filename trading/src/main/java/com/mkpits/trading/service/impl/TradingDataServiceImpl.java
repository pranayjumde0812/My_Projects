package com.mkpits.trading.service.impl;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.service.TradingDataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier
public class TradingDataServiceImpl implements TradingDataService {

    @Override
    public List<TradingDataDto> getTradingData() {

        List<TradingDataDto> tradingDataDtoList = new ArrayList<>();

        TradingDataDto tradingDataDtoList1 = TradingDataDto.builder()
                .fiftyWeeksHigh(2900.98)
                .fiftyWeeksLow(1899.07)
                .scripeName("Adani Power")
                .currentPrice(2800.71)
                .build();

        TradingDataDto tradingDataDtoList2 = TradingDataDto.builder()
                .fiftyWeeksHigh(1900.98)
                .fiftyWeeksLow(1089.07)
                .scripeName("TATA Motors")
                .currentPrice(1500.11)
                .build();

        TradingDataDto tradingDataDtoList3 = TradingDataDto.builder()
                .fiftyWeeksHigh(10000.38)
                .fiftyWeeksLow(7007.90)
                .scripeName("MRF")
                .currentPrice(7480.753)
                .build();

        TradingDataDto tradingDataDtoList4 = TradingDataDto.builder()
                .fiftyWeeksHigh(1150.98)
                .fiftyWeeksLow(699.07)
                .scripeName("IRCTC")
                .currentPrice(854.71)
                .build();

        TradingDataDto tradingDataDtoList5 = TradingDataDto.builder()
                .fiftyWeeksHigh(3290.58)
                .fiftyWeeksLow(1795.88)
                .scripeName("Coal")
                .currentPrice(2199.65)
                .build();

        tradingDataDtoList.add(tradingDataDtoList1);
        tradingDataDtoList.add(tradingDataDtoList2);
        tradingDataDtoList.add(tradingDataDtoList3);
        tradingDataDtoList.add(tradingDataDtoList4);
        tradingDataDtoList.add(tradingDataDtoList5);

        return tradingDataDtoList;
    }
}
