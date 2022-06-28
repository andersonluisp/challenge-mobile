package br.com.andersonluisdev.data.remote.mappers.orderdetails

import br.com.andersonluisdev.data.remote.model.orderdetails.VehicleDetailsResponse
import br.com.andersonluisdev.domain.model.orderdetails.VehicleDetails

fun VehicleDetailsResponse.toVehicleDetailsMapper() = VehicleDetails(
    deliveryDelay = deliveryDelay,
    doorsQtd = doorsQtd,
    engine = engine,
    engineType = engineType,
    fuelType = fuelType,
    imageUrl = imageUrl,
    km = km,
    vehicleBrand = vehicleBrand,
    vehicleModel = vehicleModel,
    vehicleYear = vehicleYear
)
