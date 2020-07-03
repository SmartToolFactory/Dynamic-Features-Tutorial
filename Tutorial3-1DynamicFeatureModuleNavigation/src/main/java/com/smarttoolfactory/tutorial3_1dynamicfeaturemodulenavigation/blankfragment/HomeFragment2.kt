package com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.blankfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.R
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.databinding.FragmentHome2Binding

class HomeFragment2 : BaseDataBindingFragment<FragmentHome2Binding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home2

    var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnIncrease.setOnClickListener {
            dataBinding.tvTitle.text = "Count: ${count++}"
        }

        dataBinding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_homeFragment3)
        }

    }

}
