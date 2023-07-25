package com.example.weatherApp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Location")
public class Location {

    @Id
    private String locationName;
    private String locationCountry;
    @Indexed(unique = true)
    private Date localTime;
    private Weather current;
    private List<ForeCast> foreCast;

}
