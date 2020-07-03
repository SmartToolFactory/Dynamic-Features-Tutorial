package com.smarttoolfactory.feature3_notification.blankfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature3_notification.R
import com.smarttoolfactory.feature3_notification.databinding.FragmentNotification1Binding
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment

class NotificationFragment1 : BaseDataBindingFragment<FragmentNotification1Binding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_notification1

    var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnIncrease.setOnClickListener {
            dataBinding.tvTitle.text = "Count: ${count++}"
        }

        dataBinding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_notificationFragment1_to_notificationFragment2)
        }

    }

}
