package com.delhiweather.weather.repository;

import com.delhiweather.weather.entity.WeatherData;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherRepository extends MongoRepository<WeatherData, String> {

    List<WeatherData> findByDatetimeUtc(LocalDateTime datetimeUtc);

    List<WeatherData> findByDatetimeUtcBetween(LocalDateTime start, LocalDateTime end);

    List<WeatherData> findByTemperatureBetween(double min, double max);

    List<WeatherData> findByHumidityBetween(int min, int max);

    List<WeatherData> findByConditionsIgnoreCase(String conditions);

    List<WeatherData> findByRainAndSnowAndThunder(int rain, int snow, int thunder);

    List<WeatherData> findAll(Sort sort);
}