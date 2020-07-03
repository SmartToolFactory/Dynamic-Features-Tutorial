package com.smarttoolfactory.feature3_dashboard.blankfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature3_dashboard.R
import com.smarttoolfactory.feature3_dashboard.databinding.FragmentDashboard3Binding
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment

class DashboardFragment3 : BaseDataBindingFragment<FragmentDashboard3Binding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_dashboard3

    var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnIncrease.setOnClickListener {
            dataBinding.tvTitle.text = "Count: ${count++}"
        }

        dataBinding.btnGoToStart.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment3_to_dashboardFragment1)
        }

    }
}
