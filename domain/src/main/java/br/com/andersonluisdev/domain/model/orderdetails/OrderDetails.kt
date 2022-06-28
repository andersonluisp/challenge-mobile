package br.com.andersonluisdev.domain.model.orderdetails

data class OrderDetails(
    val signatureDetails: SignatureDetails?,
    val summaryValues: SummaryValues?,
    val vehicleDetails: VehicleDetails?,
    val errorMessage: String?,
    val success: Boolean?
)
