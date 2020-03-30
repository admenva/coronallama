package com.threed.printmatcher.fragment.volunteer.submissions.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.MockedSubmissionList
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class VolunteerSubmissionsModel @Inject constructor(
    mockedSubmissions: MockedSubmissionList
) :
    VolunteerSubmissionsContract.Model {

    private val submissions: MutableList<Submission> = mutableListOf()

    init {
        submissions.addAll(mockedSubmissions.getSubmissionsList())
    }


    override fun getItemAt(position: Int): Submission {
        return submissions[position]
    }

    override fun getItemCount(): Int {
        return submissions.size
    }
}