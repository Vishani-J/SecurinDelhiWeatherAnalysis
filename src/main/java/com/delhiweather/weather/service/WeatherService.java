package com.delhiweather.weather.service;

import com.delhiweather.weather.dto.MonthlyTemperatureStatsDTO;

import com.delhiweather.weather.dto.WeatherDataDTO;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService {

    List<WeatherDataDTO> getWeatherByDate(LocalDate date);

    List<WeatherDataDTO> getWeatherByMonth(int year, int month);
    List<MonthlyTemperatureStatsDTO> getMonthlyTemperatureStats(int year);
}