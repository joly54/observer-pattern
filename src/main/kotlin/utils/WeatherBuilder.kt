package org.example.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.models.City
import org.example.publisher.WeatherPublisher
import org.example.publisher.weatherObserver

class WeatherBuilder(private val city: City) {
    private val weatherPublisher = WeatherPublisher(city)

    fun subscribe(observer: weatherObserver) {
        println("Subscribed $observer")
        weatherPublisher.subscribe(observer)
    }

    fun unsubscribe(observer: weatherObserver) {
        println("Unsubscribed $observer")
        weatherPublisher.unsubscribe(observer)
    }

    init {
        updateWeather()
    }

    fun notifyObservers() {
        weatherPublisher.notifyObservers()
    }

    fun updateWeather() {
        city.temperature = (0..40).random().toDouble()
        city.humidity = (0..100).random().toDouble()
        city.pressure = (700..800).random().toDouble()
        notifyObservers()
        println("Weather updated")
    }

    companion object {
        fun build(city: City) = WeatherBuilder(city)
    }
}
