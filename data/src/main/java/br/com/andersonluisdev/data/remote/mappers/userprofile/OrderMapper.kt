package br.com.andersonluisdev.data.remote.mappers.userprofile

import br.com.andersonluisdev.data.remote.model.profile.OrderResponse
import br.com.andersonluisdev.domain.model.profile.Order

fun OrderResponse.toOrderMapper() = Order(
    orderId = orderId,
    statuses = statuses?.map { it.toStatusMapper() },
    subModelName = subModelName
)
