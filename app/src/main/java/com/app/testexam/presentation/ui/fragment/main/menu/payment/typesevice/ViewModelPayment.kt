package com.app.testexam.presentation.ui.fragment.main.menu.payment.typesevice

import androidx.lifecycle.ViewModel
import com.app.testexam.R
import com.app.testexam.data.models.Services

class ViewModelPayment:ViewModel() {


    fun banckService():List<Services>{
        return listOf(
            Services("погашение кредита", R.drawable.ic_bank_svgrepo_com),
            Services("пополнение депозита", R.drawable.ic_bank_svgrepo_com),
            Services("отлатить рассрочку", R.drawable.ic_bank_svgrepo_com)
        )
    }

    fun mobileService(): List<Services> {
        return listOf(
            Services("Мегафон", R.drawable.ic_bank_svgrepo_com),
            Services("МТС", R.drawable.ic_bank_svgrepo_com),
            Services("Билайн",R.drawable.ic_bank_svgrepo_com)
        )
    }

    fun lightService(): List<Services> {
        return listOf(
            Services("Водоканал г.Душанбе",R.drawable.ic_bank_svgrepo_com),
            Services("Водоканал г.Хучанд", R.drawable.ic_business_card_bank_svgrepo_com),
            Services("ЭлектроЭнергия г,Душанбе",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("ЭлектроЭнергия г,Худжанд",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("ЭлектроЭнергия г,Бохтар",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("ЭлектроЭнергия г,Исфара",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("ЭлектроЭнергия г,Нурек",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("ЭлектроЭнергия г,Вахдат",R.drawable.ic_business_card_bank_svgrepo_com),
        )
    }
    fun internetService(): List<Services> {
        return listOf(
            Services("Билайн - оплата Интернета",R.drawable.ic_bank_svgrepo_com),
            Services("Yota - оплата Интернета", R.drawable.ic_business_card_bank_svgrepo_com),
            Services("Тоджнет",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("Телеком Технолоджи Интернет",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("Babilon-T",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("TezNet",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("Мегафон - оплата домашнего Интернет",R.drawable.ic_business_card_bank_svgrepo_com),
        )
    }
    fun taxiService(): List<Services> {
        return listOf(
            Services("Максим",R.drawable.ic_bank_svgrepo_com),
            Services("Олуча", R.drawable.ic_bank_svgrepo_com),
        )
    }
    fun transferService(): List<Services> {
        return listOf(
            Services("Пополнение карт банков России",R.drawable.ic_business_card_bank_svgrepo_com),
            Services("Пополнение карт банков Казахстана", R.drawable.ic_business_card_bank_svgrepo_com),
        )
    }
    fun tvService(): List<Services> {
        return listOf(
            Services("Сомон-ТВ",R.drawable.tv_logo),
            Services("Мавчи Истиклол", R.drawable.tv_logo),
            Services("НТВ+", R.drawable.tv_logo),
            Services("Оила-ТВ", R.drawable.tv_logo),
        )
    }

    fun socialService(): List<Services> {
        return listOf(
            Services("Skype",R.drawable.ic_social_media_svgrepo_com),
            Services("Мой мир", R.drawable.ic_social_media_svgrepo_com),
            Services("Однокласники", R.drawable.ic_social_media_svgrepo_com),
        )
    }

    fun studiesService(): List<Services> {
        return listOf(
            Services("Илмхона",R.drawable.ic_studies_svgrepo_com),
            Services("Едгир", R.drawable.ic_studies_svgrepo_com),
            Services("American School", R.drawable.ic_studies_svgrepo_com),
            Services("MBO", R.drawable.ic_studies_svgrepo_com),
        )
    }
    fun domenService(): List<Services> {
        return listOf(
            Services("RU-CENTER",R.drawable.tv_logo),
            Services("BABILON-M", R.drawable.tv_logo),
        )
    }




}