package com.delhiweather.weather.service.impl;

import com.delhiweather.weather.dto.MonthlyTemperatureStatsDTO;
import com.delhiweather.weather.dto.WeatherDataDTO;
import com.delhiweather.weather.entity.WeatherData;
import com.delhiweather.weather.repository.WeatherRepository;
import com.delhiweather.weather.service.WeatherService;
import com.delhiweather.weather.util.InvalidRequestException;
import com.delhiweather.weather.util.ResourceNotFoundException;
import com.delhiweather.weather.util.DataProcessingException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    /* ================= DATE ================= */

    @Override
    public List<WeatherDataDTO> getWeatherByDate(LocalDate date) {

        if (date == null) {
            throw new InvalidRequestException("Date parameter must not be null");
        }

        try {
            LocalDateTime start = date.atStartOfDay();
            LocalDateTime end = date.atTime(23, 59, 59);

            List<WeatherData> data =
                    weatherRepository.findByDatetimeUtcBetween(start, end);

            if (data.isEmpty()) {
                throw new ResourceNotFoundException(
                        "No weather data found for date: " + date
                );
            }

            return mapToDTO(data);

        } catch (Exception e) {
            throw new DataProcessingException(
                    "Failed to fetch weather data for date: " + date, e
            );
        }
    }

    /* ================= MONTH ================= */

    @Override
    public List<WeatherDataDTO> getWeatherByMonth(int year, int month) {

        if (month < 1 || month > 12) {
            throw new InvalidRequestException(
                    "Month must be between 1 and 12"
            );
        }

        try {
            YearMonth ym = YearMonth.of(year, month);

            List<WeatherData> data =
                    weatherRepository.findByDatetimeUtcBetween(
                            ym.atDay(1).atStartOfDay(),
                            ym.atEndOfMonth().atTime(23, 59, 59)
                    );

            if (data.isEmpty()) {
                throw new ResourceNotFoundException(
                        "No weather data found for year " + year + ", month " + month
                );
            }

            return mapToDTO(data);

        } catch (Exception e) {
            throw new DataProcessingException(
                    "Failed to fetch weather data for year " + year + ", month " + month, e
            );
        }
    }

    /* ================= YEARLY MONTH-WISE TEMPERATURE STATS ================= */

    @Override
    public List<MonthlyTemperatureStatsDTO> getMonthlyTemperatureStats(int year) {

        if (year < 1900) {
            throw new InvalidRequestException("Invalid year: " + year);
        }

        List<MonthlyTemperatureStatsDTO> result = new ArrayList<>();

        try {
            for (int month = 1; month <= 12; month++) {

                YearMonth ym = YearMonth.of(year, month);

                List<Double> temperatures = weatherRepository
                        .findByDatetimeUtcBetween(
                                ym.atDay(1).atStartOfDay(),
                                ym.atEndOfMonth().atTime(23, 59, 59)
                        )
                        .stream()
                        .map(WeatherData::getTemperature)
                        .filter(t -> t != null)
                        .sorted()
                        .toList();

                Double min = null;
                Double median = null;
                Double max = null;

                if (!temperatures.isEmpty()) {
                    min = temperatures.getFirst();
                    max = temperatures.getLast();

                    int size = temperatures.size();
                    median = (size % 2 == 0)
                            ? (temperatures.get(size / 2 - 1)
                               + temperatures.get(size / 2)) / 2
                            : temperatures.get(size / 2);
                }

                result.add(
                        new MonthlyTemperatureStatsDTO(
                                year,
                                month,
                                min,
                                median,
                                max
                        )
                );
            }

            return result;

        } catch (Exception e) {
            throw new DataProcessingException(
                    "Failed to calculate monthly temperature stats for year: " + year, e
            );
        }
    }

    /* ================= MAPPER ================= */

    private List<WeatherDataDTO> mapToDTO(List<WeatherData> entities) {
        return entities.stream()
                .map(w -> new WeatherDataDTO(
                        w.getConditions(),
                        w.getTemperature(),
                        w.getHumidity(),
                        w.getPressure()
                ))
                .toList();
    }
}