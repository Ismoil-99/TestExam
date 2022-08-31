package com.app.testexam.presentation.ui.fragment.main.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.testexam.R
import com.app.testexam.data.models.TransactionHistory
import com.app.testexam.databinding.ListCashbackBinding
import com.app.testexam.databinding.ListHistoryBinding


class AdapterHistory(
): RecyclerView.Adapter<AdapterHistory.HistoryViewHolder>() {
    private var histories = emptyList<TransactionHistory>()
    fun submit(name:List<TransactionHistory>){
        histories = name
    }


    inner class HistoryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListHistoryBinding.bind(view)
        fun bind(transaction: TransactionHistory){
            binding.nameCompany.text = transaction.nameTransaction
            binding.icon.setImageResource(transaction.imageCompany)
            binding.count.text = transaction.count
            binding.time.text = transaction.time
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_history, parent, false)
        return HistoryViewHolder(layout)
    }
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = histories[position]
        holder.bind(item)
    }
    override fun getItemCount() = histories.size
}