package com.smarttoolfactory.feature3_notification.navhost

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.smarttoolfactory.feature3_notification.R
import com.smarttoolfactory.feature3_notification.databinding.FragmentNavhostNotificationBinding
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment


class NotificationHostFragment : BaseDataBindingFragment<FragmentNavhostNotificationBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_navhost_notification

    private var navController: NavController? = null

    private val nestedNavHostFragmentId = R.id.nested_nav_host_fragment_notification

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(nestedNavHostFragmentId) as? NavHostFragment
        navController = nestedNavHostFragment?.navController

    }

}