package br.com.andersonluisdev.data.remote.mappers.orderdetails

import br.com.andersonluisdev.data.remote.model.orderdetails.SummaryValuesResponse
import br.com.andersonluisdev.domain.model.orderdetails.SummaryValues

fun SummaryValuesResponse.toSummaryValuesMapper() = SummaryValues(
    extras = extras,
    monthlyPrice = monthlyPrice,
    totalPrice = totalPrice
)
