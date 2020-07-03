package com.smarttoolfactory.feature3_notification.blankfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.smarttoolfactory.feature3_notification.R
import com.smarttoolfactory.feature3_notification.databinding.FragmentNotification2Binding
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment

class NotificationFragment2 : BaseDataBindingFragment<FragmentNotification2Binding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_notification2

    var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnIncrease.setOnClickListener {
            dataBinding.tvTitle.text = "Count: ${count++}"
        }

        dataBinding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_notificationFragment2_to_notificationFragment3)
        }

    }

}
