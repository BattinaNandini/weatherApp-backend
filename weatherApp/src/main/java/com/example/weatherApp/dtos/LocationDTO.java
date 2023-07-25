package com.example.weatherApp.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.Date;

@Data
public class LocationDTO {

    @Id
    private String locationName;
    private String locationCountry;

    @Indexed(unique=true)
    private Date localTime;

}
