package com.app.testexam.presentation.ui.fragment.main.menu.payment.pay

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.roomexamplehomework.screen.factory.ViewModelFactory
import com.app.testexam.R
import com.app.testexam.app.TestExamApp
import com.app.testexam.data.models.TransactionHistory
import com.app.testexam.databinding.FragmentPaymentBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.extensions.showActionBar
import java.time.LocalDateTime
import java.util.*



class PaymentFragment: BaseFragment<FragmentPaymentBinding>(R.layout.fragment_payment) {
    override val binding by viewBinding(FragmentPaymentBinding::bind)
    private val args: PaymentFragmentArgs by navArgs()
   // private val viewModel: ViewModelSend by viewModels()
   private val viewModel : ViewModelSend by viewModels{
       ViewModelFactory(
           (requireActivity().application as TestExamApp).database.showHistory()
       )
   }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transaction.text = args.nameCompany
        binding.imageTransaction.setImageResource(args.imageCompany)
        val idFace = binding.company.text
        val amountCurrent = binding.nameCount.text
        binding.sendCash.setOnClickListener {
            val year = Calendar.getInstance().get(Calendar.YEAR)
            val month = Calendar.getInstance().get(Calendar.MONTH)
            val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            val minute = Calendar.getInstance().get(Calendar.MINUTE)
            val localeTime = LocalDateTime.of(year,month,day,hour,minute)
            //val history = TransactionHistory( args.nameCompany!!,args.imageCompany,idFace,amountCurrent,time.toString())
               viewModel.addTransaction(TransactionHistory(
                   nameTransaction = args.nameCompany!!,
                   imageCompany = args!!.imageCompany,
                   idCount = idFace.toString(),
                   count = amountCurrent.toString(),
                   time = localeTime.toString()
               ))
            Log.d("count","$idFace")
        }
    }
    override fun onResume() {
        super.onResume()
        showActionBar()
        (requireActivity() as AppCompatActivity).supportActionBar?.title = ""
    }
}