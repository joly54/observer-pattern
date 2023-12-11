package org.example.publisher

import org.example.models.City

class WeatherPublisher(private val city: City) {
    private val observers: MutableList<weatherObserver> = mutableListOf()

    fun subscribe(observer: weatherObserver) {
        println("Subscribed $observer")
        observers.add(observer)
    }

    fun unsubscribe(observer: weatherObserver) {
        observers.remove(observer)
    }

    fun notifyObservers() {
        observers.forEach {
            it.update(city.temperature, city.humidity, city.pressure)
        }
    }
}
