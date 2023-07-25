package com.example.weatherApp.services;

import com.example.weatherApp.entities.Astrology;
import com.example.weatherApp.entities.ForeCast;
import com.example.weatherApp.entities.Location;
import com.example.weatherApp.entities.Weather;
import java.util.List;

public interface LocationService {
    public List<Location> getAllLocation();
    public Location addLocation(Location location);
    public Location findByLocationName(String locationName);
    public boolean addForecastToLocation(String locationName, ForeCast foreCast);
    public boolean addHourlyForeCast(String locationName,String dateOfForeCast, Weather weather);
    public boolean addAstrology(String locationName, String dateOfForeCast, Astrology astrology);
    public boolean addDailyForeCast(String locationName, String dateOfForeCast, Weather weather);

}
