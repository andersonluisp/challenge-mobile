package br.com.andersonluisdev.data.remote.model.orderdetails

import com.google.gson.annotations.SerializedName

data class OrderDetailsResponse(
    @SerializedName("signature_details")
    val signatureDetails: SignatureDetailsReponse?,
    @SerializedName("summary_values")
    val summaryValues: SummaryValuesResponse?,
    @SerializedName("vehicle_details")
    val vehicleDetails: VehicleDetailsResponse?,
    @SerializedName("error_message")
    val errorMessage: String?,
    val success: Boolean?
)
