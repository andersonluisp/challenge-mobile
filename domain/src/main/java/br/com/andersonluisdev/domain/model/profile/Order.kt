package br.com.andersonluisdev.domain.model.profile

data class Order(
    val orderId: Int?,
    val statuses: List<Status>?,
    val subModelName: String?
)
