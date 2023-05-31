CREATE TABLE trading_data(
                             scripe_id INT AUTO_INCREMENT NOT NULL,
                             scripe_name VARCHAR(25) NOT NULL,
                             fifty_weeks_high DOUBLE NOT NULL,
                             fifty_weeks_low DOUBLE NOT NULL,
                             current_price DOUBLE NOT NULL,
                             PRIMARY KEY(scripe_id )
);