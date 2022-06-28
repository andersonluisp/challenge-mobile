package br.com.andersonluisdev.data.remote.model.orderdetails

import com.google.gson.annotations.SerializedName

data class VehicleDetailsResponse(
    @SerializedName("delivery_delay")
    val deliveryDelay: Int?,
    @SerializedName("doors_qtd")
    val doorsQtd: Int?,
    val engine: String?,
    @SerializedName("engine_type")
    val engineType: String?,
    @SerializedName("fuel_type")
    val fuelType: String?,
    @SerializedName("image_url")
    val imageUrl: List<String>?,
    val km: Int?,
    @SerializedName("vehicle_brand")
    val vehicleBrand: String?,
    @SerializedName("vehicle_model")
    val vehicleModel: String?,
    @SerializedName("vehicle_year")
    val vehicleYear: Int?
)
