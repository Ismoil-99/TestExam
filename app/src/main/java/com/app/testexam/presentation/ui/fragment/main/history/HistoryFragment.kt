package com.app.testexam.presentation.ui.fragment.main.history

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.roomexamplehomework.screen.factory.ViewModelFactory
import com.app.testexam.R
import com.app.testexam.app.TestExamApp
import com.app.testexam.data.models.TransactionHistory
import com.app.testexam.databinding.FragmentHistoryBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.extensions.hideActionBar
import com.app.testexam.presentation.extensions.showActionBar
import com.app.testexam.presentation.ui.fragment.main.menu.payment.pay.ViewModelSend

class HistoryFragment:BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
    override val binding by viewBinding(FragmentHistoryBinding::bind)
    private lateinit var recyclerViewHistory: RecyclerView

    private val viewModel : ViewModelSend by viewModels{
        ViewModelFactory(
            (requireActivity().application as TestExamApp).database.showHistory()
        )
    }

    override fun onResume() {
        super.onResume()
        showActionBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        recyclerViewHistory = binding.historyRecycler
        val adapterHistory = AdapterHistory()
        viewModel.allItems.observe(requireActivity()) {
            Log.d("history", "$it")
            adapterHistory.submit(it)
        }
        recyclerViewHistory.adapter = adapterHistory
        recyclerViewHistory.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
    }
}