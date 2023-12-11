package org.example.models

import org.example.publisher.weatherObserver

data class City(
    val name: String,
    var temperature: Double? = null,
    var humidity: Double? = null,
    var pressure: Double? = null,

): weatherObserver{
    override fun update(temperature: Double?, humidity: Double?, pressure: Double?) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
    }
    val weather: Unit
    get() {
        println("The weather in $name temp: $temperature humidity: $humidity pressure: $pressure")
    }
}
