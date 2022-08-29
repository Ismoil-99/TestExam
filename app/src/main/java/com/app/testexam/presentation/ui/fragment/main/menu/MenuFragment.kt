package com.app.testexam.presentation.ui.fragment.main.menu

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.app.ID
import com.app.testexam.app.TestExamApp
import com.app.testexam.data.models.Services
import com.app.testexam.databinding.FragmentMenuBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.extensions.activityNavController
import com.app.testexam.presentation.extensions.hideActionBar
import com.app.testexam.presentation.extensions.navigateSafely
import com.app.testexam.presentation.ui.fragment.main.menu.cashback.CashbackAdapter
import com.app.testexam.presentation.ui.fragment.main.menu.payment.listservice.ListServiceFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment:BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    override val binding by viewBinding(FragmentMenuBinding::bind)
    private val viewModel:MenuViewModel by viewModels()
    private lateinit var recyclerViewService: RecyclerView
    private lateinit var recyclerCashback: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currency()
        val listServices = viewModel.listServices()
        val listCashback = viewModel.cashbackList()
        servicesAdapter(listServices)
        cashbackAdapter(listCashback)
        binding.allServices.setOnClickListener {
            val direction = ListServiceFragmentDirections.actionGlobalToListservice(1)
           activityNavController().navigateSafely(direction)
        }
        binding.allCashback.setOnClickListener {
            val direction = MenuFragmentDirections.actionMenuFragmentToShowCashBackFragment(1)
            findNavController().navigateSafely(direction)
        }
        viewModel.currencyData.observe(requireActivity()){
            Log.d("currency","$it")
        }
    }

    private fun cashbackAdapter(listCashback: List<Int>) {
        recyclerCashback = binding.recyclerCashback
        recyclerCashback.adapter = CashbackAdapter(listCashback,0)
        recyclerCashback.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
    }

    private fun servicesAdapter(listServices: List<Services>) {
        recyclerCashback = binding.recyclerServices
        val id = TestExamApp.sharedPreferencesEditor
        recyclerCashback.adapter = ServicesAdapter(listServices,0){
            id.putInt(ID,it)
            id.apply()
            activityNavController().navigateSafely(R.id.from_global_to_typeservice)
        }
        recyclerCashback.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
    }

    override fun onResume() {
        super.onResume()
        hideActionBar()
    }
}