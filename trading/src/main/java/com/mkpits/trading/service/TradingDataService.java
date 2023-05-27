package com.mkpits.trading.service;

import com.mkpits.trading.dto.response.TradingDataDto;

import java.util.List;

public interface TradingDataService {

    public List<TradingDataDto> getTradingData();
}
