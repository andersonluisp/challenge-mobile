package br.com.andersonluisdev.home.presentation.fragment.orderdetails.mapper

import br.com.andersonluisdev.domain.model.orderdetails.OrderDetails
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.dataui.OrderDetailsDataUi

fun OrderDetails.toOrderDetailsDataUiMapper() = OrderDetailsDataUi(
    signatureDetails = signatureDetails?.toSignatureDetailsDataUiMapper(),
    summaryValues = summaryValues?.toSummaryValuesDataUiMapper(),
    vehicleDetails = vehicleDetails?.toVehicleDetailsDataUiMapper(),
    errorMessage = errorMessage,
    success = success
)
