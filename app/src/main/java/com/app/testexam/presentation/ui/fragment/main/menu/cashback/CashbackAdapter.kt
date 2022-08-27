package com.app.testexam.presentation.ui.fragment.main.menu.cashback

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.testexam.R
import com.app.testexam.databinding.ListCashbackBinding

class CashbackAdapter(private val cashback: List<Int>) : RecyclerView.Adapter<CashbackAdapter.CashbackViewHolder>() {
    inner class CashbackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListCashbackBinding.bind(view)
        fun bind(cashback: Int){
            binding.cashback.setImageResource(cashback)
        }
    }

    override fun getItemCount() = cashback.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashbackViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_cashback, parent, false)
        return CashbackViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CashbackAdapter.CashbackViewHolder, position: Int) {
        val item = cashback[position]
        holder.bind(item)
    }
}