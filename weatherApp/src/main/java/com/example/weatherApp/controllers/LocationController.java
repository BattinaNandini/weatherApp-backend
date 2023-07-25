package com.example.weatherApp.controllers;

import com.example.weatherApp.dtos.LocationDTO;
import com.example.weatherApp.entities.Astrology;
import com.example.weatherApp.entities.ForeCast;
import com.example.weatherApp.entities.Location;
import com.example.weatherApp.entities.Weather;
import com.example.weatherApp.services.impl.LocationImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationImpl locationImpl;



    @GetMapping("/getAllLocation")
    public List<Location> getLocation() {
        return locationImpl.getAllLocation();
    }

    @PostMapping("/addLocation")
    public ResponseEntity<String> addLocation(@RequestBody LocationDTO locationDTO){
        Location location=new Location();
        BeanUtils.copyProperties(locationDTO,location);
        Location locationCreated = locationImpl.addLocation(location);
        return new ResponseEntity<String>(locationCreated.toString(),HttpStatus.OK);
    }

    @GetMapping("/findByLocationName/{locationName}")
    public Location findByLocationName(@PathVariable String locationName){
        return locationImpl.findByLocationName(locationName);
    }

    @PostMapping("/addHourlyForeCast/{locationName}/{dateOfForeCast}")
    public ResponseEntity<String> addHourlyForeCast(@PathVariable String locationName,@PathVariable String dateOfForeCast, @RequestBody Weather weather){
        if (locationImpl.addHourlyForeCast(locationName,dateOfForeCast,weather)) {
            return new ResponseEntity<>("hour forecast added successfully", HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(" cannot add forecast", HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/addAstrology/{locationName}/{dateOfForeCast}")
    public ResponseEntity<String> addAstrology(@PathVariable String locationName,@PathVariable String dateOfForeCast, @RequestBody Astrology astrology) {
        if(locationImpl.addAstrology(locationName,dateOfForeCast,astrology)) {
            return new ResponseEntity<>("astrology added successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(" cannot add astrology", HttpStatus.BAD_REQUEST);

        }

    }
    @PostMapping("/addDailyForeCast/{locationName}/{dateOfForeCast}")
    public ResponseEntity<String> addDailyForeCast(@PathVariable String locationName,@PathVariable String dateOfForeCast, @RequestBody Weather weather) {
        if(locationImpl.addDailyForeCast(locationName,dateOfForeCast,weather)){
        return new ResponseEntity<>("day forecast added successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(" cannot add forecast", HttpStatus.BAD_REQUEST);

        }

    }
    }
