package com.threed.supply.libs.model

import com.threed.supply.app.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class MockedRequests @Inject constructor() {

    private val items: MutableList<Request> = mutableListOf()

    init {
        items.add(
            Request(
                "Protective Face Shields",
                "The London Hospital",
                "PPE is needed immediately to protect the caregivers who are risking their own health to care for patients in the most need",
                "Whitechapel Rd, London, United Kingdom",
                "https://cdn.prusa3d.com/wp-content/uploads/2020/03/shield-1.jpg#_ga=2.232288287.1611879560.1585533938-907588876.1585361799",
                1000,
                900
            )
        )
        items.add(
            Request(
                "pair of gloves",
                "University College Hospital",
                "description",
                "235 Euston Rd, Bloomsbury, London NW1 2BU, United Kingdom",
                "https://ameralabs.com/uploads/SLA-3D-printing-safety-measures.jpg",
                2000,
                1900
            )
        )
        items.add(
            Request(
                "respirator valves",
                "Barts Health NHS Trust",
                "description",
                "The Royal London Hospital, Whitechapel Rd, London E1 1BB",
                "https://idtxs3.imgix.net/si/40000/64/96.jpg?w=800",
                500,
                475
            )
        )
        items.add(
            Request(
                "shoe covers",
                "St Thomas' Hospital",
                "description",
                "Westminster Bridge Rd, Bishop's, London SE1 7EH, United Kingdom",
                "https://images-na.ssl-images-amazon.com/images/I/81Csmw6HMtL._AC_SX466_.jpg",
                250,
                125
            )
        )
    }

    fun getRequestsList(): List<Request> {
        return items
    }
}