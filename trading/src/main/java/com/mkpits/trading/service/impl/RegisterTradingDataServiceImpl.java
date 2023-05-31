package com.mkpits.trading.service.impl;

import com.mkpits.trading.dto.response.TradingDataDto;
import com.mkpits.trading.h2db.model.TradingDataH2Model;
import com.mkpits.trading.h2db.repository.TradingDataH2Repo;
import com.mkpits.trading.mysql.model.TradingDataMySqlModel;
import com.mkpits.trading.mysql.repository.TradingDataMySqlRepo;
import com.mkpits.trading.service.RegisterTradingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class RegisterTradingDataServiceImpl implements RegisterTradingDataService {

    @Autowired
    TradingDataMySqlRepo tradingDataMySqlRepo;

    @Autowired
    TradingDataH2Repo tradingDataH2Repo;

    public RegisterTradingDataServiceImpl(@Qualifier("h2db") TradingDataH2Repo tradingDataH2Repo, @Qualifier("mysql") TradingDataMySqlRepo tradingDataMySqlRepo) {
        this.tradingDataMySqlRepo = tradingDataMySqlRepo;
        this.tradingDataH2Repo = tradingDataH2Repo;
    }

    @Override
    public TradingDataDto getRegistrationData(TradingDataDto tradingDataDto) {

        TradingDataMySqlModel tradingDataMySqlModel = TradingDataMySqlModel.builder()
                .scripeName(tradingDataDto.getScripeName())
                .fiftyWeeksHigh(tradingDataDto.getFiftyWeeksHigh())
                .fiftyWeeksLow(tradingDataDto.getFiftyWeeksLow())
                .currentPrice(tradingDataDto.getCurrentPrice())
                .build();

        TradingDataMySqlModel afterSave1 = tradingDataMySqlRepo.save(tradingDataMySqlModel);
        tradingDataDto.setId(afterSave1.getId());


        //        Added For H2 Database
        TradingDataH2Model tradingDataH2Model = TradingDataH2Model.builder()
                .scripeName(tradingDataDto.getScripeName())
                .fiftyWeeksHigh(tradingDataDto.getFiftyWeeksHigh())
                .fiftyWeeksLow(tradingDataDto.getFiftyWeeksLow())
                .currentPrice(tradingDataDto.getCurrentPrice())
                .build();

        TradingDataH2Model afterSave2 = tradingDataH2Repo.save(tradingDataH2Model);
        tradingDataDto.setId(afterSave2.getId());


        return tradingDataDto;
    }
}
