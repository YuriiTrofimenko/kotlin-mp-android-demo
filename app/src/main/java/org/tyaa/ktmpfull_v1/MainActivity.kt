package org.tyaa.ktmpfull_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // example 1
        /* val textView: TextView =
            findViewById(R.id.android_text) as TextView
        textView.setText(provideSharedData()) */

        // example 2
        val weatherApi = WeatherApi()
        launch(Dispatchers.Main) {
            try {
                val result = withContext(Dispatchers.IO) { weatherApi.fetchWeather() }
                Toast.makeText(this@MainActivity, result, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
