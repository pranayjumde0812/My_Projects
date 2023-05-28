package com.mkpits.trading.repository;

import com.mkpits.trading.model.TradingDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingDataRepo extends JpaRepository<TradingDataModel,Long> {
}
