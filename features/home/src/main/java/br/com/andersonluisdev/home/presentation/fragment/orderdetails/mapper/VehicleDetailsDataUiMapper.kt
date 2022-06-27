package br.com.andersonluisdev.home.presentation.fragment.orderdetails.mapper

import br.com.andersonluisdev.domain.model.orderdetails.VehicleDetails
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.dataui.VehicleDetailsDataUi

fun VehicleDetails.toVehicleDetailsDataUiMapper() = VehicleDetailsDataUi(
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
