package com.app.testexam.presentation.ui.fragment.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.testexam.R
import com.app.testexam.data.models.Services
import com.app.testexam.databinding.ListServicesBinding

class ServicesAdapter(private val services:List<Services>) : RecyclerView.Adapter<ServicesAdapter.ServiceViewHolder>() {
    inner class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListServicesBinding.bind(view)
        fun bind(list: Services){
            binding.imageServices.setImageResource(list.imageServices)
            binding.nameServices.text = list.nameServices
        }
    }

    override fun getItemCount() = services.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_services, parent, false)
        return ServiceViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ServicesAdapter.ServiceViewHolder, position: Int) {
        val item = services[position]
        holder.bind(item)
    }
}