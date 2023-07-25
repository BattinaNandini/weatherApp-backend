package com.example.weatherApp.entities;

import lombok.Data;

@Data
public class Weather {

    private String time;
    private double temperature;
    private double humidity;
    private String condition;

}
