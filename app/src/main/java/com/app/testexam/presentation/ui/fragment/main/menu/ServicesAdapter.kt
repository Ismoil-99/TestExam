package com.app.testexam.presentation.ui.fragment.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.testexam.R
import com.app.testexam.data.models.Services
import com.app.testexam.databinding.ListPaymentBinding
import com.app.testexam.databinding.ListServicesBinding

class ServicesAdapter(private val services:List<Services>,private val idType:Int,private val onItemClick:(Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListServicesBinding.bind(view)
        fun bind(list: Services){
            binding.imageServices.setImageResource(list.imageServices)
            binding.nameServices.text = list.nameServices
            itemView.setOnClickListener {
                onItemClick.invoke(bindingAdapterPosition)
            }
        }
    }
    inner class PaymentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListPaymentBinding.bind(view)
        fun bind(list: Services){
            binding.imageServices.setImageResource(list.imageServices)
            binding.nameServices.text = list.nameServices
            itemView.setOnClickListener {
                onItemClick.invoke(bindingAdapterPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        if (idType == 0){
            return Const.HORIZONTAL
        }else if (idType == 1){
            return Const.VERTICAL
        }
        return 0
    }

    override fun getItemCount() = services.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Const.HORIZONTAL) {
             val view = LayoutInflater.from(parent.context).inflate(R.layout.list_services,parent,false)
            ServiceViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_payment,parent,false)
            PaymentViewHolder(view)
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == Const.HORIZONTAL){
            (holder as ServiceViewHolder).bind(services[position])
        }else{
            (holder as PaymentViewHolder).bind(services[position])
        }
    }
    private object Const{
        const val HORIZONTAL = 0
        const val VERTICAL = 1
    }
}