package com.threed.supply.libs.util

import com.threed.supply.app.di.ApplicationScope
import java.util.*
import javax.inject.Inject

@ApplicationScope
class DateCreator @Inject constructor() {

    fun createDate(year: Int, month: Int, day: Int): Date {
        val cal = Calendar.getInstance()
        cal[Calendar.YEAR] = year
        cal[Calendar.MONTH] = month
        cal[Calendar.DAY_OF_MONTH] = day
        return cal.time
    }
}