package com.mkpits.trading.service.impl;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.model.TradingDataModel;
import com.mkpits.trading.repository.TradingDataRepo;
import com.mkpits.trading.service.RegisterTradingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterTradingDataServiceImpl implements RegisterTradingDataService {

    @Autowired
    TradingDataRepo tradingDataRepo;

    @Override
    public TradingDataDto getRegistrationData(TradingDataDto tradingDataDto) {

        TradingDataModel tradingDataModel = TradingDataModel.builder()
                .scripeName(tradingDataDto.getScripeName())
                .fiftyWeeksHigh(tradingDataDto.getFiftyWeeksHigh())
                .fiftyWeeksLow(tradingDataDto.getFiftyWeeksLow())
                .currentPrice(tradingDataDto.getCurrentPrice())
                .build();

        TradingDataModel afterSave = tradingDataRepo.save(tradingDataModel);
        tradingDataDto.setId(afterSave.getId());

        return tradingDataDto;
    }
}
