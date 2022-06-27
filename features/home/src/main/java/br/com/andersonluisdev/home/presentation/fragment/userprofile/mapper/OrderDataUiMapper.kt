package br.com.andersonluisdev.home.presentation.fragment.userprofile.mapper

import br.com.andersonluisdev.domain.model.profile.Order
import br.com.andersonluisdev.home.presentation.fragment.userprofile.dataui.OrderDataUi

fun Order.toOrderDataUiMapperMapper() = OrderDataUi(
    orderId = orderId,
    statuses = statuses?.map { it.toStatusDataUiMapper() },
    subModelName = subModelName
)
