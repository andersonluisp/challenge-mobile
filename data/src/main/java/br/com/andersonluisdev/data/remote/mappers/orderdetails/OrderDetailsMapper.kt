package br.com.andersonluisdev.data.remote.mappers.orderdetails

import br.com.andersonluisdev.data.remote.model.ErrorResponse
import br.com.andersonluisdev.data.remote.model.orderdetails.OrderDetailsResponse
import br.com.andersonluisdev.domain.model.orderdetails.OrderDetails

fun OrderDetailsResponse.toOrderDetailsMapper() = OrderDetails(
    signatureDetails = signatureDetails?.toSignatureDetailsMapper(),
    summaryValues = summaryValues?.toSummaryValuesMapper(),
    vehicleDetails = vehicleDetails?.toVehicleDetailsMapper(),
    errorMessage = errorMessage,
    success = success
)

fun ErrorResponse.toOrderDetailsMapper() = OrderDetails(
    signatureDetails = null,
    summaryValues = null,
    vehicleDetails = null,
    errorMessage = errorMessage,
    success = success
)
