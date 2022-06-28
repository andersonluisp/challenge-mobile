package br.com.andersonluisdev.home.presentation.fragment.orderdetails.dataui

data class OrderDetailsDataUi(
    val signatureDetails: SignatureDetailsDataUi?,
    val summaryValues: SummaryValuesDataUi?,
    val vehicleDetails: VehicleDetailsDataUi?,
    val errorMessage: String?,
    val success: Boolean?
)
