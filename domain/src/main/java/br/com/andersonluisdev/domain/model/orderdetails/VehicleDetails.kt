package br.com.andersonluisdev.domain.model.orderdetails

data class VehicleDetails(
    val deliveryDelay: Int?,
    val doorsQtd: Int?,
    val engine: String?,
    val engineType: String?,
    val fuelType: String?,
    val imageUrl: List<String>?,
    val km: Int?,
    val vehicleBrand: String?,
    val vehicleModel: String?,
    val vehicleYear: Int?
)
