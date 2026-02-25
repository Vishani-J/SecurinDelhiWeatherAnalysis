package com.delhiweather.weather.controller;

import com.delhiweather.weather.dto.MonthlyTemperatureStatsDTO;
import com.delhiweather.weather.dto.WeatherDataDTO;
import com.delhiweather.weather.service.WeatherService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/date")
    public List<WeatherDataDTO> getWeatherByDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return weatherService.getWeatherByDate(date);
    }

    @GetMapping("/month")
    public List<WeatherDataDTO> getWeatherByMonth(
            @RequestParam int year,
            @RequestParam int month) {

        return weatherService.getWeatherByMonth(year, month);
    }

    @GetMapping("/temperature-stats")
    public List<MonthlyTemperatureStatsDTO> getMonthlyTemperatureStats(
            @RequestParam int year
    ) {
        return weatherService.getMonthlyTemperatureStats(year);
    }
}