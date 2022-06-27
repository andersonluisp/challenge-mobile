package br.com.andersonluisdev.home.presentation.fragment.orderdetails.mapper

import br.com.andersonluisdev.domain.model.orderdetails.SummaryValues
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.dataui.SummaryValuesDataUi

fun SummaryValues.toSummaryValuesDataUiMapper() = SummaryValuesDataUi(
    extras = extras,
    monthlyPrice = monthlyPrice,
    totalPrice = totalPrice
)
