package com.weather.demo.service;

import com.weather.demo.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private RestTemplate restTemplate;

    @Autowired
    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public ResponseModel getWeather(double lon, double lat) {
        ResponseModel response = restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon +
                        "&appid=19fc20151b4f7e31688097a3cc1ffdcf",
                ResponseModel.class);
        return response;
    }
}
