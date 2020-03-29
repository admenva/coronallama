package com.threed.printmatcher.fragment.home.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Request
import javax.inject.Inject

@FragmentScope
class VolunteerHomeModel @Inject constructor() : VolunteerHomeContract.Model {

    private val items: MutableList<Request> = mutableListOf()

    init {
        items.add(
            Request(
                "masks",
                "The Royal London Hospital",
                "description",
                "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                "https://www.bartshealth.nhs.uk/media/images/versions/img94joktmu717322.jpg",
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
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/University_College_Hospital_-_New_Building_-_London_-_020504.jpg",
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
                "https://d3d00swyhr67nd.cloudfront.net/_source/COL_BAR_collection_image.jpg",
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
                "https://www.southwarknews.co.uk/wp-content/uploads/2016/09/St_Thomas_Hospital_-_SB.jpg",
                250,
                125
            )
        )
        items.add(
            Request(
                "masks",
                "The Royal London Hospital",
                "description",
                "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                "https://www.bartshealth.nhs.uk/media/images/versions/img94joktmu717322.jpg",
                1000,
                560
            )
        )
        items.add(
            Request(
                "pair of gloves",
                "University College Hospital",
                "description",
                "235 Euston Rd, Bloomsbury, London NW1 2BU, United Kingdom",
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/University_College_Hospital_-_New_Building_-_London_-_020504.jpg",
                2000,
                1870
            )
        )
        items.add(
            Request(
                "respirator valves",
                "Barts Health NHS Trust",
                "description",
                "The Royal London Hospital, Whitechapel Rd, London E1 1BB",
                "https://d3d00swyhr67nd.cloudfront.net/_source/COL_BAR_collection_image.jpg",
                500,
                500
            )
        )
        items.add(
            Request(
                "shoe covers",
                "St Thomas' Hospital",
                "description",
                "Westminster Bridge Rd, Bishop's, London SE1 7EH, United Kingdom",
                "https://www.southwarknews.co.uk/wp-content/uploads/2016/09/St_Thomas_Hospital_-_SB.jpg",
                250,
                100
            )
        )
        items.add(
            Request(
                "masks",
                "The Royal London Hospital",
                "description",
                "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                "https://www.bartshealth.nhs.uk/media/images/versions/img94joktmu717322.jpg",
                1000,
                1000
            )
        )
        items.add(
            Request(
                "pair of gloves",
                "University College Hospital",
                "description",
                "235 Euston Rd, Bloomsbury, London NW1 2BU, United Kingdom",
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/University_College_Hospital_-_New_Building_-_London_-_020504.jpg",
                2000,
                10
            )
        )
        items.add(
            Request(
                "respirator valves",
                "Barts Health NHS Trust",
                "description",
                "The Royal London Hospital, Whitechapel Rd, London E1 1BB",
                "https://d3d00swyhr67nd.cloudfront.net/_source/COL_BAR_collection_image.jpg",
                500,
                465
            )
        )
        items.add(
            Request(
                "shoe covers",
                "St Thomas' Hospital",
                "description",
                "Westminster Bridge Rd, Bishop's, London SE1 7EH, United Kingdom",
                "https://www.southwarknews.co.uk/wp-content/uploads/2016/09/St_Thomas_Hospital_-_SB.jpg",
                250,
                120
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemAt(position: Int): Request {
        return items[position]
    }

}