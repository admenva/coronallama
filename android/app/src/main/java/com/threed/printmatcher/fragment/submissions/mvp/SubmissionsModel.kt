package com.threed.printmatcher.fragment.submissions.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.MockedSubmissionList
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class SubmissionsModel @Inject constructor(
    mockedSubmissions: MockedSubmissionList,
    submissionFromPreviousPage: Submission
) :
    SubmissionsContract.Model {

    private val submissions: MutableList<Submission> = mutableListOf()

    init {
        submissions.add(submissionFromPreviousPage)
        submissions.addAll(mockedSubmissions.getSubmissionsList())
    }


    override fun getItemAt(position: Int): Submission {
        return submissions[position]
    }

    override fun getItemCount(): Int {
        return submissions.size
    }
}