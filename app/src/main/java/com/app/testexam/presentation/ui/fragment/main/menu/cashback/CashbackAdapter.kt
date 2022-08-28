package com.app.testexam.presentation.ui.fragment.main.menu.cashback

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.testexam.R
import com.app.testexam.databinding.ListCashbackBinding
import com.app.testexam.presentation.ui.fragment.main.menu.ServicesAdapter

class CashbackAdapter(private val cashback: List<Int>,private val id :Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class CashbackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListCashbackBinding.bind(view)
        fun bind(cashback: Int){
            binding.cashback.setImageResource(cashback)
        }
    }

    inner class AllCashbackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListCashbackBinding.bind(view)
        fun bind(cashback: Int){
            binding.cashback.setImageResource(cashback)
        }
    }
    override fun getItemCount() = cashback.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Const.HORIZONTAL) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_cashback,parent,false)
            CashbackViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_all_cashback,parent,false)
            AllCashbackViewHolder(view)
        }
    }
    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        if (id == 0){
            return Const.HORIZONTAL
        }else if (id == 1){
            return Const.VERTICAL
        }
        return 0
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) ==Const.HORIZONTAL){
            (holder as CashbackViewHolder).bind(cashback[position])
        }else{
            (holder as AllCashbackViewHolder).bind(cashback[position])
        }

    }
    private object Const{
        const val HORIZONTAL = 0
        const val VERTICAL = 1
    }
}