package com.example.weatherApp.services.impl;

import com.example.weatherApp.entities.Astrology;
import com.example.weatherApp.entities.ForeCast;
import com.example.weatherApp.entities.Location;
import com.example.weatherApp.entities.Weather;
import com.example.weatherApp.repositories.ForeCastRepository;
import com.example.weatherApp.repositories.LocationRepository;
import com.example.weatherApp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ForeCastRepository foreCastRepository;

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location findByLocationName(String locationName) {

        try {

            Optional<Location> locationOptional = locationRepository.findById(locationName);
//            if (((Optional) locationOptional).isPresent()) {
                Location location = locationOptional.get();
                return location;
//            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean addForecastToLocation(String locationName, ForeCast foreCast) {

        try {
            Optional<Location> locationOptional = locationRepository.findById(locationName);
//        if (((Optional) locationOptional).isPresent()) {
            Location location = locationOptional.get();
            List<ForeCast> foreCastList = location.getForeCast();
            System.out.println(foreCastRepository.findById(foreCast.getDate().toString()));
            if (foreCastList == null) {
                foreCastList = new ArrayList<>();

            } else if (foreCastRepository.findById(foreCast.getDate()).toString() != "Optional.empty") {
                int indexOfForeCast;

                for (indexOfForeCast = 0; indexOfForeCast < foreCastList.size(); indexOfForeCast++) {
                    if (foreCastList.get(indexOfForeCast).getDate().equals(foreCast.getDate())) {
                        System.out.println("im out...........");
                        break;
                    }
                }
                foreCastList.remove(indexOfForeCast);
            }

            foreCastRepository.save(foreCast);
            foreCastList.add(foreCast);
            System.out.println(foreCastRepository.findAll());
            location.setForeCast((foreCastList));
            locationRepository.save(location);
            return true;
//        }
        } catch (Exception i) {
            System.out.println("cannot add or update the data");
            return false;
        }

    }

    @Override
    public boolean addHourlyForeCast(String locationName, String dateOfForeCast, Weather weather) {

        ForeCast foreCast = getIsOptional(locationName, dateOfForeCast);
        List<Weather> weatherList = new ArrayList<>();
        if (foreCast.getHour() != null) {
            weatherList = foreCast.getHour();
            for (int index = 0; index < weatherList.size(); index++) {
                if (weatherList.get(index).getTime().equals(weather.getTime())) {
                    weatherList.remove(index);
                    break;
                }
            }
        }
        foreCast.setDate(dateOfForeCast);
        weatherList.add(weather);
        foreCast.setHour(weatherList);
        return addForecastToLocation(locationName, foreCast);

    }


    @Override
    public boolean addAstrology(String locationName, String dateOfForeCast, Astrology astrology) {

        ForeCast foreCast = getIsOptional(locationName, dateOfForeCast);
        foreCast.setDate(dateOfForeCast);
        foreCast.setAstrology(astrology);
        return addForecastToLocation(locationName, foreCast);

    }

    @Override
    public boolean addDailyForeCast(String locationName, String dateOfForeCast, Weather weather) {

        ForeCast foreCast = getIsOptional(locationName, dateOfForeCast);
        foreCast.setDate(dateOfForeCast);
        foreCast.setDay(weather);
        return addForecastToLocation(locationName, foreCast);

    }

    public ForeCast getIsOptional(String locationName, String dateOfForeCast) {
        try {

            Optional<Location> locationOptional = locationRepository.findById(locationName);
//            if (((Optional) locationOptional).isPresent()) {
            ForeCast foreCast = new ForeCast();
            Optional<ForeCast> foreCastOptional = foreCastRepository.findById(dateOfForeCast);
            if (((Optional) foreCastOptional).isPresent()) {
                return foreCastOptional.get();
            }
            return foreCast;
//            }
        } catch (Exception i) {
            System.out.println("location not found");
            return null;
        }
    }


}
