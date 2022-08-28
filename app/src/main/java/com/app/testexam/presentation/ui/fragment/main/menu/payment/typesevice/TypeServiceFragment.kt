package com.app.testexam.presentation.ui.fragment.main.menu.payment.typesevice

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.app.testexam.R
import com.app.testexam.app.ID
import com.app.testexam.app.TestExamApp
import com.app.testexam.data.models.Services
import com.app.testexam.databinding.FragmentTypeServiceBinding
import com.app.testexam.presentation.base.BaseFragment
import com.app.testexam.presentation.extensions.activityNavController
import com.app.testexam.presentation.extensions.navigateSafely
import com.app.testexam.presentation.extensions.overrideOnBackPressed
import com.app.testexam.presentation.extensions.showActionBar

class TypeServiceFragment: BaseFragment<FragmentTypeServiceBinding>(R.layout.fragment_type_service) {
    override val binding by viewBinding(FragmentTypeServiceBinding::bind)
    private val viewModel: ViewModelPayment by viewModels()
    private lateinit var servicerecyclerView: RecyclerView
    private var service:List<Services> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when(TestExamApp.sharedPreferences.getInt(ID,0)){
            0 ->{service = viewModel.banckService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Услуги Банка"
            }
            1 ->{
                service = viewModel.mobileService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Мобильная связь"
            }
            2 ->{service = viewModel.lightService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Свет,вода"
            }
            3 ->{service = viewModel.internetService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Услуги интернет"
            }
            4 ->{service = viewModel.taxiService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Такси"
            }
            5 ->{service = viewModel.transferService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Карты,переводы"
            }
            6 ->{service = viewModel.tvService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "ТВ"
            }
            7 ->{service = viewModel.socialService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Социальные сети"
            }
            8 ->{service = viewModel.studiesService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Учеба"
            }
            9 ->{service = viewModel.domenService()
                (requireActivity() as AppCompatActivity).supportActionBar?.title = "Домены"
            }
        }
        setupAdapter(service)
    }

    private fun setupAdapter(service: List<Services>) {
        servicerecyclerView = binding.listService
        servicerecyclerView.adapter = AdapterTypeService(service){
            findNavController().navigateSafely(R.id.action_typeServiceFragment_to_paymentFragment)
        }
        servicerecyclerView.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
    }

    override fun onResume() {
        super.onResume()
        showActionBar()
    }
}