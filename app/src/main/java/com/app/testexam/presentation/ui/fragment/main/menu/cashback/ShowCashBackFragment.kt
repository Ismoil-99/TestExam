package com.app.testexam.presentation.ui.fragment.main.menu.cashback

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.databinding.FragmentShowCashbackBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.extensions.showActionBar
import com.app.testexam.presentation.ui.fragment.main.menu.MenuViewModel

class ShowCashBackFragment: BaseFragment<FragmentShowCashbackBinding>(R.layout.fragment_show_cashback) {
    override val binding by viewBinding(FragmentShowCashbackBinding::bind)
    private lateinit var recyclerAllCashback: RecyclerView

    private val args: ShowCashBackFragmentArgs by navArgs()
    private val viewModel: MenuViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listCashback = viewModel.cashbackList()
        setupCashback(listCashback)
    }
    private fun setupCashback(listCashback: List<Int>) {
        recyclerAllCashback = binding.recyclerCashback
        recyclerAllCashback.adapter = CashbackAdapter(listCashback,args.id)
        recyclerAllCashback.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
    }

    override fun onResume() {
        super.onResume()
        showActionBar()
    }
}