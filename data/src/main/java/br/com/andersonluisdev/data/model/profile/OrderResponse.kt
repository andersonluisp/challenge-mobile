package br.com.andersonluisdev.data.model.profile

import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("order_id")
    val orderId: Int?,
    val statuses: List<StatusResponse>?,
    @SerializedName("submodel_name")
    val subModelName: String?
)
