package com.threed.printmatcher.fragment.submissions.institution.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class InstitutionSubmissionsModel @Inject constructor():InstitutionSubmissionsContract.Model {
    override fun getItemAt(position: Int): Submission {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}