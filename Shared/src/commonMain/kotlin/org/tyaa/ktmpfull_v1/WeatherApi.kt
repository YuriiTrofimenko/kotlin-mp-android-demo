package org.tyaa.ktmpfull_v1

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class WeatherApi() {

    private val client = HttpClient()

    suspend fun fetchWeather(): String {
            return client.get<String> {
                url("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        }
    }
    companion object {
        private const val baseUrl = "https://samples.openweathermap.org"
    }
}