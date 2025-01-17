package br.com.andersonluisdev.data.remote.model.profile

import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("order_id")
    val orderId: Int?,
    val statuses: List<StatusResponse>?,
    @SerializedName("submodel_name")
    val subModelName: String?,
    @SerializedName("error_message")
    val errorMessage: String?,
    val success: Boolean?
)
