package org.tyaa.ktmpfull_v1

import kotlinx.serialization.Serializable

@Serializable
data class Weather(val coord: Coordinate, val base: String)