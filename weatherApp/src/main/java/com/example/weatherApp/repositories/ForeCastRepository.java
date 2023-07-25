package com.example.weatherApp.repositories;


import com.example.weatherApp.entities.ForeCast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeCastRepository extends MongoRepository<ForeCast, String> {
}
