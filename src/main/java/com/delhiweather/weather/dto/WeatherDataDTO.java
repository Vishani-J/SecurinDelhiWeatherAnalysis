package com.delhiweather.weather.dto;

public class WeatherDataDTO {

    private String condition;
    private Double temperature;
    private Integer humidity;
    private Double pressure;

    public WeatherDataDTO() {}

    public WeatherDataDTO(String condition, Double temperature,
                          Integer humidity, Double pressure) {
        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public String getCondition() {
        return condition;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Double getPressure() {
        return pressure;
    }
}