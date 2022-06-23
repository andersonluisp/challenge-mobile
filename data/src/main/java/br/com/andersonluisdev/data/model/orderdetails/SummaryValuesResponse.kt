package br.com.andersonluisdev.data.model.orderdetails

import com.google.gson.annotations.SerializedName

data class SummaryValuesResponse(
    val extras: String?,
    @SerializedName("monthly_price")
    val monthlyPrice: String?,
    @SerializedName("total_price")
    val totalPrice: String?
)
