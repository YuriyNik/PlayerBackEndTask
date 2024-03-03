CREATE TABLE IF NOT EXISTS players (
    player_id VARCHAR(255) PRIMARY KEY,
    birth_year INT,
    birth_month INT,
    birth_day INT,
    birth_country VARCHAR(255),
    birth_state VARCHAR(255),
    birth_city VARCHAR(255),
    death_year INT,
    death_month INT,
    death_day INT,
    death_country VARCHAR(255),
    death_state VARCHAR(255),
    death_city VARCHAR(255),
    name_first VARCHAR(255),
    name_last VARCHAR(255),
    name_given VARCHAR(255),
    weight INT,
    height INT,
    bats VARCHAR(1),
    throws VARCHAR(1),
    debut DATE,
    final_game DATE,
    retro_id VARCHAR(255),
    bbref_id VARCHAR(255)
    );

INSERT INTO players (player_id, birth_year, birth_month, birth_day, birth_country, birth_state, birth_city, death_year, death_month, death_day, death_country, death_state, death_city, name_first, name_last, name_given, weight, height, bats, throws, debut, final_game, retro_id, bbref_id)
SELECT * FROM CSVREAD('classpath:player.csv');


