package com.app.testexam.presentation.ui.fragment.main.menu.payment.pay

import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.databinding.FragmentPaymentBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.extensions.showActionBar

class PaymentFragment: BaseFragment<FragmentPaymentBinding>(R.layout.fragment_payment) {
    override val binding by viewBinding(FragmentPaymentBinding::bind)

    override fun onResume() {
        super.onResume()
        showActionBar()
        (requireActivity() as AppCompatActivity).supportActionBar?.title = ""
    }
}