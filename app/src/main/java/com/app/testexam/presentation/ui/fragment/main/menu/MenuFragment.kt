package com.app.testexam.presentation.ui.fragment.main.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.data.models.Services
import com.app.testexam.databinding.FragmentMenuBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.ui.fragment.main.menu.cashback.CashbackAdapter

class MenuFragment:BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    override val binding by viewBinding(FragmentMenuBinding::bind)
    private val viewModel:MenuViewModel by viewModels()
    private lateinit var recyclerViewService: RecyclerView
    private lateinit var recyclerCashback: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listServices = viewModel.listServices()
        val listCashback = viewModel.cashbackList()
        servicesAdapter(listServices)
        cashbackAdapter(listCashback)
    }

    private fun cashbackAdapter(listCashback: List<Int>) {
        recyclerCashback = binding.recyclerCashback
        recyclerCashback.adapter = CashbackAdapter(listCashback)
        recyclerCashback.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
    }

    private fun servicesAdapter(listServices: List<Services>) {
        recyclerViewService = binding.recyclerServices
        recyclerViewService.adapter = ServicesAdapter(listServices)
        recyclerViewService.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
    }
}