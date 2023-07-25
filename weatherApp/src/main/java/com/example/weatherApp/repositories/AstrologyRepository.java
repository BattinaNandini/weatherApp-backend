package com.example.weatherApp.repositories;

import com.example.weatherApp.entities.Astrology;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstrologyRepository extends MongoRepository<Astrology,String> {
}
