package com.mkpits.trading.service.impl;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.h2db.model.TradingDataH2Model;
import com.mkpits.trading.h2db.repository.TradingDataH2Repo;
import com.mkpits.trading.mysql.model.TradingDataMySqlModel;
import com.mkpits.trading.mysql.repository.TradingDataMySqlRepo;
import com.mkpits.trading.service.TradingRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class TradingRegServiceImpl implements TradingRegService {

    @Autowired
    @Qualifier("mysql")
    TradingDataMySqlRepo tradingDataMySqlRepo;

    @Autowired
    @Qualifier("h2db")
    TradingDataH2Repo tradingDataH2Repo;
    @Override
    public List<TradingDataDto> getAllRegistrationData() {

        List<TradingDataDto> tradingDtoList =new ArrayList<>();

        //////////// For MySQL

        List<TradingDataMySqlModel> tradingDataMySqlModelList =tradingDataMySqlRepo.findAll();

        tradingDataMySqlModelList.stream().forEach(tradingDataModel -> {
            TradingDataDto tradingDataDtoMysql =TradingDataDto.builder()
                    .scripeName(tradingDataModel.getScripeName())
                    .fiftyWeeksHigh(tradingDataModel.getFiftyWeeksHigh())
                    .fiftyWeeksLow(tradingDataModel.getFiftyWeeksLow())
                    .currentPrice(tradingDataModel.getCurrentPrice())
                    .build();

            tradingDtoList.add(tradingDataDtoMysql);
        });

        ////// For H2 database
        List<TradingDataH2Model> tradingDataH2ModelList =tradingDataH2Repo.findAll();

        tradingDataH2ModelList.stream().forEach(tradingDataModel -> {
            TradingDataDto tradingDataDtoH2 =TradingDataDto.builder()
                    .scripeName(tradingDataModel.getScripeName())
                    .fiftyWeeksHigh(tradingDataModel.getFiftyWeeksHigh())
                    .fiftyWeeksLow(tradingDataModel.getFiftyWeeksLow())
                    .currentPrice(tradingDataModel.getCurrentPrice())
                    .build();

            tradingDtoList.add(tradingDataDtoH2);
        });

        return tradingDtoList;
    }
}
