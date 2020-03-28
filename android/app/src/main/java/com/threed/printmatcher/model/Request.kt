package com.threed.printmatcher.model

data class Request constructor(
    val title: String,
    val hospitalName: String,
    val location: String,
    val imageResource: String
)