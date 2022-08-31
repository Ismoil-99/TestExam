package com.app.testexam.presentation.ui.fragment.main.menu.payment.listservice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavHost
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.app.ID
import com.app.testexam.app.TestExamApp
import com.app.testexam.databinding.FragmentHistoryBinding
import com.app.testexam.databinding.FragmentServiceBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.extensions.activityNavController
import com.app.testexam.presentation.extensions.navigateSafely
import com.app.testexam.presentation.extensions.showActionBar
import com.app.testexam.presentation.ui.fragment.main.menu.MenuViewModel
import com.app.testexam.presentation.ui.fragment.main.menu.ServicesAdapter


class ListServiceFragment:BaseFragment<FragmentServiceBinding>(R.layout.fragment_service) {
    override val binding by viewBinding(FragmentServiceBinding::bind)
    private lateinit var listServiceRecyclerView: RecyclerView
    private val viewModel: MenuViewModel by viewModels()
    private val args:ListServiceFragmentArgs by navArgs()
    override fun onResume() {
        super.onResume()
        showActionBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentBack()
        val listService = viewModel.listServices()
        val id = TestExamApp.sharedPreferencesEditor
        listServiceRecyclerView = binding.listService
        listServiceRecyclerView.adapter = ServicesAdapter(listService,args.id){
            id.putInt(ID,it)
            id.apply()
            activityNavController().navigateSafely(R.id.from_global_to_typeservice)
        }
        listServiceRecyclerView.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
    }

    private fun currentBack() {
        val navHost = requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHost
        val navController = navHost.navController
        NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar),navController,null)
    }
}