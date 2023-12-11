package org.example

import org.example.models.City
import org.example.utils.WeatherBuilder

fun main() {
    val vinnitsa = City("Vinnitsa")

    val weatherSystem = WeatherBuilder.build(vinnitsa)

    weatherSystem.subscribe(vinnitsa)
    weatherSystem.updateWeather()
    vinnitsa.weather

    weatherSystem.unsubscribe(vinnitsa)
    weatherSystem.updateWeather()
    vinnitsa.weather
}