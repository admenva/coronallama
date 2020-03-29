package com.threed.printmatcher.model

import com.threed.printmatcher.app.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class MockedRequests @Inject constructor() {

    private val items: MutableList<Request> = mutableListOf()

    init {
        items.add(
            Request(
                "masks",
                "The Royal London Hospital",
                "description",
                "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                "https://www.3dprintingmedia.network/wp-content/uploads/2020/03/despiece-en-plano-780x470.png",
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