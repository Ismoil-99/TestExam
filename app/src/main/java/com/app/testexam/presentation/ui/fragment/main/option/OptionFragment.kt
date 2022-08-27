package com.app.testexam.presentation.ui.fragment.main.option

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.databinding.FragmentOptionBinding
import com.app.testexam.databinding.FragmentPayBinding
import com.app.testexam.presentation.base.BaseFragment

class OptionFragment:BaseFragment<FragmentOptionBinding>(R.layout.fragment_option) {
    override val binding by viewBinding(FragmentOptionBinding::bind)
}