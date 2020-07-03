package com.smarttoolfactory.feature3_dashboard.blankfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature3_dashboard.R
import com.smarttoolfactory.feature3_dashboard.databinding.FragmentDashboard2Binding
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment

class DashboardFragment2 : BaseDataBindingFragment<FragmentDashboard2Binding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_dashboard2

    var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnIncrease.setOnClickListener {
            dataBinding.tvTitle.text = "Count: ${count++}"
        }

        dataBinding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment2_to_dashboardFragment3)
        }

    }


}
