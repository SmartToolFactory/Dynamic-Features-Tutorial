package com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.blankfragment


import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.lifecycle.Observer
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.fragment.findNavController
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.R
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.base.BaseDataBindingFragment
import com.smarttoolfactory.tutorial3_1dynamicfeaturemodulenavigation.databinding.FragmentMainBinding


class MainFragment : BaseDataBindingFragment<FragmentMainBinding>() {

    /**
     * [DynamicInstallMonitor] is for monitoring installation progress of a dynamic module
     * after we tried to navigate to it and under circumstances that it's not available.
     */
    val installMonitor = DynamicInstallMonitor()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Navigate to Home in this module
        dataBinding.btnDestHome.setOnClickListener {

//            findNavController().navigate(
//                R.id.action_mainFragment_to_nav_graph_home,
//                null,
//                null,
//                DynamicExtras(installMonitor)
//            )

            navigateWithInstallMonitor(R.id.action_mainFragment_to_nav_graph_home)
        }

        dataBinding.btnDestDashboard.setOnClickListener {

//            findNavController().navigate(
//                R.id.nav_graph_dashboard,
//                null,
//                null,
//                DynamicExtras(installMonitor)
//            )

            // FIXME Only navigates to first fragment, navController can not find others
            navigateWithInstallMonitor(R.id.action_mainFragment_to_nav_graph_dashboard)

        }

        dataBinding.btnDashboardActivity.setOnClickListener {

//            findNavController().navigate(
//                R.id.dashboardActivity,
//                null,
//                null,
//                DynamicExtras(installMonitor)
//            )

            navigateWithInstallMonitor(R.id.action_mainFragment_to_dashboardActivity)


        }

        dataBinding.btnDestNotification.setOnClickListener {

//            findNavController().navigate(
//                R.id.nav_graph_notification,
//                null,
//                null,
//                DynamicExtras(installMonitor)
//            )

            navigateWithInstallMonitor(R.id.action_mainFragment_to_nav_graph_notification)

        }

    }

    private fun navigateWithInstallMonitor(@IdRes destinationId: Int) {

        findNavController().navigate(
            destinationId,
            null,
            null,
            DynamicExtras(installMonitor)
        )

        println("MainFragment isInstallRequired: ${installMonitor.isInstallRequired}")

        if (installMonitor.isInstallRequired) {

            installMonitor.status.observe(
                viewLifecycleOwner,
                object : Observer<SplitInstallSessionState> {

                    override fun onChanged(sessionState: SplitInstallSessionState) {

                        when (sessionState.status()) {

                            SplitInstallSessionStatus.INSTALLED -> {
                                // Call navigate again here or after user taps again in the UI:
                                findNavController().navigate(destinationId, null, null, null)
                            }
                            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
//                            SplitInstallManager.startConfirmationDialogForResult(...)
                            }

                            // Handle all remaining states:
                            SplitInstallSessionStatus.FAILED -> {
                            }
                            SplitInstallSessionStatus.CANCELED -> {
                            }

                        }

                        if (sessionState.hasTerminalStatus()) {
                            installMonitor.status.removeObserver(this)
                        }
                    }
                })
        }

    }

    override fun getLayoutRes(): Int = R.layout.fragment_main

}
