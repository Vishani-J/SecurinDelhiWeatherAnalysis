package com.delhiweather.weather.dto;

public class MonthlyTemperatureStatsDTO {

    private int year;
    private int month;
    private Double minTemperature;
    private Double medianTemperature;
    private Double maxTemperature;

    public MonthlyTemperatureStatsDTO(
            int year,
            int month,
            Double minTemperature,
            Double medianTemperature,
            Double maxTemperature
    ) {
        this.year = year;
        this.month = month;
        this.minTemperature = minTemperature;
        this.medianTemperature = medianTemperature;
        this.maxTemperature = maxTemperature;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public Double getMedianTemperature() {
        return medianTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }
}