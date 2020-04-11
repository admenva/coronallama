package com.threed.supply.libs.model

import java.io.Serializable
import java.util.*

data class Submission constructor(
    val request: Request,
    val state: State,
    val committedQuantity: Int,
    val committedDate: Date
) : Serializable

enum class State {
    PENDING, DELIVERED
}