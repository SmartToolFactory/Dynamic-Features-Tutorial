package com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.blankfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.R
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.databinding.FragmentHome3Binding

class HomeFragment3 : BaseDataBindingFragment<FragmentHome3Binding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_home3

    var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnIncrease.setOnClickListener {
            dataBinding.tvTitle.text = "Count: ${count++}"
        }

        dataBinding.btnGoToStart.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment3_to_homeFragment1)
        }
    }
}
