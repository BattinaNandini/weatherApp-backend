# Backend
The provided code consists of a Spring Boot Java application with a REST controller and a service class to handle weather data retrieval based on a city's location name. The `WeatherController` is responsible for handling incoming HTTP requests and contains a method `getWeatherByLocationName`, which takes the `locationName` as a path variable. Inside the method, it calls the `WeatherService`, which holds the business logic for fetching weather data. If the weather data is found, the method returns a `WeatherData` object with an HTTP status code of 200 (OK). If the data is not found, it returns an HTTP status code of 404 (Not Found). This setup allows users to access the weather report of a city by providing its name as a parameter in the URL, making it easy and convenient to get weather updates for various locations.

# Project setup
- `<java.version>11</java.version>`
- `<maven.compiler.source>11</maven.compiler.source>`
- `<maven.compiler.target>11</maven.compiler.target>`
- `<dependency>` section:
  - `spring-boot-starter-web` (version 2.5.4)
