package br.com.andersonluisdev.data.remote.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    val success: Boolean?,
    @SerializedName("error_message")
    val errorMessage: String?
)
