package com.app.testexam.presentation.ui.fragment.main

import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.databinding.FragmentFlowMainBinding
import com.app.testexam.presentation.base.BaseFlowFragment
import com.app.testexam.presentation.extensions.hideActionBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFlowFragment:BaseFlowFragment(R.layout.fragment_flow_main,R.id.fragment_container_view) {
    private val binding by viewBinding(FragmentFlowMainBinding::bind)
    override fun onResume() {
        super.onResume()
        hideActionBar()
    }
    override fun setupNavigation(navController: NavController) {
        binding.bottomNavigation.setupWithNavController(navController)
        NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar), navController, null)
    }
}