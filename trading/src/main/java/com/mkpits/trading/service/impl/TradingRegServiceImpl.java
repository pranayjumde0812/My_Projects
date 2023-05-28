package com.mkpits.trading.service.impl;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.model.TradingDataModel;
import com.mkpits.trading.repository.TradingDataRepo;
import com.mkpits.trading.service.TradingRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Primary
public class TradingRegServiceImpl implements TradingRegService {

    @Autowired
    TradingDataRepo tradingDataRepo;
    @Override
    public List<TradingDataDto> getAllRegistrationData() {

        List<TradingDataDto> tradingDtoList =new ArrayList<>();

        List<TradingDataModel> tradingDataModelList =tradingDataRepo.findAll();


        tradingDataModelList.stream().forEach(tradingDataModel -> {
            TradingDataDto tradingDataDto =TradingDataDto.builder()
                    .scripeName(tradingDataModel.getScripeName())
                    .fiftyWeeksHigh(tradingDataModel.getFiftyWeeksHigh())
                    .fiftyWeeksLow(tradingDataModel.getFiftyWeeksLow())
                    .currentPrice(tradingDataModel.getCurrentPrice())
                    .build();

            tradingDtoList.add(tradingDataDto);
        });

        return tradingDtoList;
    }
}
