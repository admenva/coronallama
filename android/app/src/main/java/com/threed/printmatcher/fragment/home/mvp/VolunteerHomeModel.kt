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
                "1000 masks",
                "The Royal London Hospital",
                "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                "https://www.bartshealth.nhs.uk/media/images/versions/img94joktmu717322.jpg"
            )
        )
        items.add(
            Request(
                "2000 pair of gloves",
                "University College Hospital",
                "235 Euston Rd, Bloomsbury, London NW1 2BU, United Kingdom",
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/University_College_Hospital_-_New_Building_-_London_-_020504.jpg"
            )
        )
        items.add(
            Request(
                "500 respirator valves",
                "Barts Health NHS Trust",
                "The Royal London Hospital, Whitechapel Rd, London E1 1BB",
                "https://d3d00swyhr67nd.cloudfront.net/_source/COL_BAR_collection_image.jpg"
            )
        )
        items.add(
            Request(
                "250 shoe covers",
                "St Thomas' Hospital",
                "Westminster Bridge Rd, Bishop's, London SE1 7EH, United Kingdom",
                "https://www.southwarknews.co.uk/wp-content/uploads/2016/09/St_Thomas_Hospital_-_SB.jpg"
            )
        )
        items.add(
            Request(
                "1000 masks",
                "The Royal London Hospital",
                "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                "https://www.bartshealth.nhs.uk/media/images/versions/img94joktmu717322.jpg"
            )
        )
        items.add(
            Request(
                "2000 pair of gloves",
                "University College Hospital",
                "235 Euston Rd, Bloomsbury, London NW1 2BU, United Kingdom",
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/University_College_Hospital_-_New_Building_-_London_-_020504.jpg"
            )
        )
        items.add(
            Request(
                "500 respirator valves",
                "Barts Health NHS Trust",
                "The Royal London Hospital, Whitechapel Rd, London E1 1BB",
                "https://d3d00swyhr67nd.cloudfront.net/_source/COL_BAR_collection_image.jpg"
            )
        )
        items.add(
            Request(
                "250 shoe covers",
                "St Thomas' Hospital",
                "Westminster Bridge Rd, Bishop's, London SE1 7EH, United Kingdom",
                "https://www.southwarknews.co.uk/wp-content/uploads/2016/09/St_Thomas_Hospital_-_SB.jpg"
            )
        )
        items.add(
            Request(
                "1000 masks",
                "The Royal London Hospital",
                "Whitechapel Rd, Whitechapel, London E1 1FR, United Kingdom",
                "https://www.bartshealth.nhs.uk/media/images/versions/img94joktmu717322.jpg"
            )
        )
        items.add(
            Request(
                "2000 pair of gloves",
                "University College Hospital",
                "235 Euston Rd, Bloomsbury, London NW1 2BU, United Kingdom",
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/University_College_Hospital_-_New_Building_-_London_-_020504.jpg"
            )
        )
        items.add(
            Request(
                "500 respirator valves",
                "Barts Health NHS Trust",
                "The Royal London Hospital, Whitechapel Rd, London E1 1BB",
                "https://d3d00swyhr67nd.cloudfront.net/_source/COL_BAR_collection_image.jpg"
            )
        )
        items.add(
            Request(
                "250 shoe covers",
                "St Thomas' Hospital",
                "Westminster Bridge Rd, Bishop's, London SE1 7EH, United Kingdom",
                "https://www.southwarknews.co.uk/wp-content/uploads/2016/09/St_Thomas_Hospital_-_SB.jpg"
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemAt(position: Int): Request {
        return items.get(position)
    }

}