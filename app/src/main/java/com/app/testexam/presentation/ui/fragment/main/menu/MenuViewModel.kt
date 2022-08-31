package com.app.testexam.presentation.ui.fragment.main.menu


import androidx.lifecycle.ViewModel
import com.app.testexam.R
import com.app.testexam.data.models.Services


class MenuViewModel:ViewModel() {


    fun listServices():List<Services>{
        return listOf(
            Services("Услуги Банка", R.drawable.ic_bank_svgrepo_com),
            Services("Мобильная связь",R.drawable.ic_mobile_phone_svgrepo_com ),
            Services("Свет,вода", R.drawable.ic_light_bulb_svgrepo_com),
            Services("Услуги интернет",R.drawable.ic_internet_svgrepo_com ),
            Services("Такси", R.drawable.ic_taxi_svgrepo_com),
            Services("Карты,переводы",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("ТВ",R.drawable.ic_tv_svgrepo_com),
            Services("Социальные сети", R.drawable.ic_social_media_svgrepo_com),
            Services("Учеба", R.drawable.ic_studies_svgrepo_com),
            Services("Домены", R.drawable.ic_www_svgrepo_com),
        )
    }
    fun cashbackList():List<Int>{
        return listOf(
            R.drawable.cashback1,
            R.drawable.cashback2,
            R.drawable.cashback3,
            R.drawable.cashback4,
        )
    }
}