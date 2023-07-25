package com.example.weatherApp.repositories;

import com.example.weatherApp.entities.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WeatherRepository extends MongoRepository<Weather,String> {
}
