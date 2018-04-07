package com.nurina.sani20;

public class weeklyForecast {

    private int idIconWeeklyForecast;
    private String dayWeeklyForecast;

    public weeklyForecast(int idIconWeeklyForecast, String dayWeeklyForecast) {
        this.idIconWeeklyForecast = idIconWeeklyForecast;
        this.dayWeeklyForecast = dayWeeklyForecast;
    }

    public int getIdIconWeeklyForecast() {
        return idIconWeeklyForecast;
    }

    public void setIdIconWeeklyForecast(int idIconWeeklyForecast) {
        this.idIconWeeklyForecast = idIconWeeklyForecast;
    }

    public String getDayWeeklyForecast() {
        return dayWeeklyForecast;
    }

    public void setDayWeeklyForecast(String dayWeeklyForecast) {
        this.dayWeeklyForecast = dayWeeklyForecast;
    }
}
