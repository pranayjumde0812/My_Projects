package com.mkpits.trading.h2db.repository;

import com.mkpits.trading.h2db.model.TradingDataH2Model;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("h2db")
public interface TradingDataH2Repo extends JpaRepository<TradingDataH2Model,Long> {
}
