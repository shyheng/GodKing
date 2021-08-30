package com.shy.list_weather;

public class HourWeather {
    private String year;
    private String month;
    private String day;
    private String hour;
    private String windDirection;
    private String windPower;
    private String weather;
    private String temperature;

    public HourWeather() {
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return this.hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindPower() {
        return this.windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String toString() {
        return "HourWeather{year='" + this.year + '\'' + ", month='" + this.month + '\'' + ", day='" + this.day + '\'' + ", hour='" + this.hour + '\'' + ", windDirection='" + this.windDirection + '\'' + ", windPower='" + this.windPower + '\'' + ", weather='" + this.weather + '\'' + ", temperature='" + this.temperature + '\'' + '}';
    }
}

