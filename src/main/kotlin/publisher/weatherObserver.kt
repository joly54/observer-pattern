package org.example.publisher

interface weatherObserver {
    fun update(temperature: Double?, humidity: Double?, pressure: Double?)
}