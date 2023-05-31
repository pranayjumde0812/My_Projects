package com.mkpits.trading.mysql.repository;

import com.mkpits.trading.mysql.model.TradingDataMySqlModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mysql")
public interface TradingDataMySqlRepo extends JpaRepository< TradingDataMySqlModel , Long> {
}
