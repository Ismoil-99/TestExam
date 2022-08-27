package com.app.testexam.presentation.ui.fragment.main.history

import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.databinding.FragmentHistoryBinding
import com.app.testexam.presentation.base.BaseFragment

class HistoryFragment:BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
    override val binding by viewBinding(FragmentHistoryBinding::bind)
}