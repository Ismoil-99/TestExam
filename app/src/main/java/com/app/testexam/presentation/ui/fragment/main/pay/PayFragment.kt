package com.app.testexam.presentation.ui.fragment.main.pay

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.databinding.FragmentPayBinding
import com.app.testexam.presentation.base.BaseFragment

class PayFragment:BaseFragment<FragmentPayBinding>(R.layout.fragment_pay) {
    override val binding by viewBinding(FragmentPayBinding::bind)
}