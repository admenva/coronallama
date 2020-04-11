package com.threed.supply.libs.model

import java.io.Serializable

data class Request constructor(
    val title: String,
    val hospitalName: String,
    val description: String,
    val location: String,
    val imageResource: String,
    val requested: Int,
    val stillNeeded: Int
) : Serializable