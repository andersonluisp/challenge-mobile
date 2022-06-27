package br.com.andersonluisdev.home.presentation.fragment.myprofile.dataui

data class OrderDataUi (
    val orderId: Int?,
    val statuses: List<StatusDataUi>?,
    val subModelName: String?
)
