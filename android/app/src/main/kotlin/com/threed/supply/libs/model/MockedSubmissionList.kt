package com.threed.supply.libs.model

import com.threed.supply.app.di.ApplicationScope
import com.threed.supply.libs.util.DateCreator
import javax.inject.Inject

@ApplicationScope
class MockedSubmissionList @Inject constructor(dateCreator: DateCreator) {

    private val items: MutableList<Submission> = mutableListOf()

    init {
        items.add(
            Submission(
                Request(
                    "masks",
                    "The Royal London Hospital",
                    "description",
                    "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                    "https://www.bartshealth.nhs.uk/media/images/versions/img94joktmu717322.jpg",
                    1000,
                    850
                ),
                State.PENDING,
                50,
                dateCreator.createDate(2020, 6, 10)
            )
        )

        items.add(
            Submission(
                Request(
                    "pair of gloves",
                    "University College Hospital",
                    "description",
                    "235 Euston Rd, Bloomsbury, London NW1 2BU, United Kingdom",
                    "https://upload.wikimedia.org/wikipedia/commons/b/b5/University_College_Hospital_-_New_Building_-_London_-_020504.jpg",
                    2000,
                    2000
                ),
                State.PENDING,
                120,
                dateCreator.createDate(2020, 7, 5)
            )
        )

        items.add(
            Submission(
                Request(
                    "respirator valves",
                    "Barts Health NHS Trust",
                    "description",
                    "The Royal London Hospital, Whitechapel Rd, London E1 1BB",
                    "https://d3d00swyhr67nd.cloudfront.net/_source/COL_BAR_collection_image.jpg",
                    500,
                    120
                ),
                State.DELIVERED,
                200,
                dateCreator.createDate(2020, 7, 15)
            )
        )
    }

    fun getSubmissionsList(): List<Submission> {
        return items
    }
}