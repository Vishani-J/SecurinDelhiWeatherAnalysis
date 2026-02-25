package com.delhiweather.weather.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "weather")
public class WeatherData {
    @Id
    private String id;
    private LocalDateTime datetimeUtc;

    private String conditions;

    private Double dewPoint;

    private Integer fog;

    private Integer hail;

    private Double heatIndex;

    private Integer humidity;

    private Double precipitation;

    private Double pressure;

    private Integer rain;

    private Integer snow;

    private Double temperature;

    private Integer thunder;

    private Integer tornado;

    private Double visibility;

    private Integer windDirectionDegree;

    private String windDirection;

    private Double windGust;

    private Double windChill;

    private Double windSpeed;


    public String getId() {
        return id;
    }

    public LocalDateTime getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(LocalDateTime datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Integer getFog() {
        return fog;
    }

    public void setFog(Integer fog) {
        this.fog = fog;
    }

    public Integer getHail() {
        return hail;
    }

    public void setHail(Integer hail) {
        this.hail = hail;
    }

    public Double getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(Double heatIndex) {
        this.heatIndex = heatIndex;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Integer getRain() {
        return rain;
    }

    public void setRain(Integer rain) {
        this.rain = rain;
    }

    public Integer getSnow() {
        return snow;
    }

    public void setSnow(Integer snow) {
        this.snow = snow;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getThunder() {
        return thunder;
    }

    public void setThunder(Integer thunder) {
        this.thunder = thunder;
    }

    public Integer getTornado() {
        return tornado;
    }

    public void setTornado(Integer tornado) {
        this.tornado = tornado;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Integer getWindDirectionDegree() {
        return windDirectionDegree;
    }

    public void setWindDirectionDegree(Integer windDirectionDegree) {
        this.windDirectionDegree = windDirectionDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Double getWindChill() {
        return windChill;
    }

    public void setWindChill(Double windChill) {
        this.windChill = windChill;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
}