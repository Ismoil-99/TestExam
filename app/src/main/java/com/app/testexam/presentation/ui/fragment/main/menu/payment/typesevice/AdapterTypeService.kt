package com.app.testexam.presentation.ui.fragment.main.menu.payment.typesevice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.testexam.R
import com.app.testexam.data.models.Services
import com.app.testexam.databinding.ListTypeServiceBinding

class AdapterTypeService(
    private val payment: List<Services>,
    private val onItemClick:(Int) -> Unit
): RecyclerView.Adapter<AdapterTypeService.PartViewHolder>() {

    inner class PartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListTypeServiceBinding.bind(view)
        fun bind(payment: Services){
            binding.nameServices.text = payment.nameServices
            binding.imageServices.setImageResource(payment.imageServices)
            itemView.setOnClickListener {
                onItemClick.invoke(bindingAdapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_type_service, parent, false)
        return PartViewHolder(layout)
    }
    override fun onBindViewHolder(holder: PartViewHolder, position: Int) {
        val item = payment[position]
        holder.bind(item)
    }
    override fun getItemCount() = payment.size

}