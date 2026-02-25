package com.delhiweather.weather.repository;

import com.delhiweather.weather.entity.WeatherData;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherRepository extends MongoRepository<WeatherData, String> {

    List<WeatherData> findByDatetimeUtc(LocalDateTime datetimeUtc);
    List<WeatherData> findByDatetimeUtcBetween(
            LocalDateTime start,
            LocalDateTime end
    );
    @Query("{ 'temperature': { $gte: ?0, $lte: ?1 } }")
    List<WeatherData> findByTemperatureBetween(double min, double max);

    @Query("{ 'humidity': { $gte: ?0, $lte: ?1 } }")
    List<WeatherData> findByHumidityBetween(int min, int max);

    List<WeatherData> findByConditionsIgnoreCase(String conditions);

    @Query("""
        {
          $and: [
            { 'rain': ?0 },
            { 'snow': ?1 },
            { 'thunder': ?2 }
          ]
        }
        """)
    List<WeatherData> findByWeatherEvents(
            int rain,
            int snow,
            int thunder
    );

    List<WeatherData> findAll(Sort sort);
}