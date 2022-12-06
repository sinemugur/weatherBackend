package com.weather.demo.resource;

import com.weather.demo.model.ResponseModel;
import com.weather.demo.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class WeatherResource {
    private WeatherService weatherService;

    public WeatherResource(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/1.0/weather/{lon}/{lat}")
    public ResponseEntity<ResponseModel> getUretimHatlari(@PathVariable("lon") double lon,
                                                          @PathVariable("lat") double lat) {
        return ResponseEntity.ok(weatherService.getWeather(lon, lat));
    }
}
