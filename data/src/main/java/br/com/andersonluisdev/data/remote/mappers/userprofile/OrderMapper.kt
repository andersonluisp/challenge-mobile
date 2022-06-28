package br.com.andersonluisdev.data.remote.mappers.userprofile

import br.com.andersonluisdev.data.remote.model.ErrorResponse
import br.com.andersonluisdev.data.remote.model.profile.OrderResponse
import br.com.andersonluisdev.domain.model.profile.Order

fun OrderResponse.toOrderMapper() = Order(
    orderId = orderId,
    statuses = statuses?.map { it.toStatusMapper() },
    subModelName = subModelName,
    errorMessage = errorMessage,
    success = success
)

fun ErrorResponse.toOrderMapper() = Order(
    orderId = null,
    statuses = null,
    subModelName = null,
    errorMessage = errorMessage,
    success = success
)
