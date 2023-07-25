package com.example.weatherApp.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "ForeCast")
public class ForeCast {

    @Id
    private String date;
    private Astrology astrology;
    private Weather Day;
    private List<Weather> Hour;

}
