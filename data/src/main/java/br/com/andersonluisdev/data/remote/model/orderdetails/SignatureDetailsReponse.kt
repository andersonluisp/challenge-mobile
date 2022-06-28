package br.com.andersonluisdev.data.remote.model.orderdetails

import com.google.gson.annotations.SerializedName

data class SignatureDetailsReponse(
    @SerializedName("additional_franchise")
    val additionalFranchise: String?,
    val months: Int?,
    @SerializedName("plan_type")
    val planType: Int?
)
