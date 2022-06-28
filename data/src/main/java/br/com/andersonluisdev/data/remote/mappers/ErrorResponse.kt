package br.com.andersonluisdev.data.remote.mappers

import br.com.andersonluisdev.data.remote.model.ErrorResponse
import com.google.gson.Gson
import okhttp3.ResponseBody

fun ResponseBody.toErrorResponseMapper() : ErrorResponse {
    val gson = Gson()
    return gson.fromJson(
        this.charStream(),
        ErrorResponse::class.java
    )
}
