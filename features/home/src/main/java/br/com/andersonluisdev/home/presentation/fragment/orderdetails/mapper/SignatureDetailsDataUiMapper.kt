package br.com.andersonluisdev.home.presentation.fragment.orderdetails.mapper

import br.com.andersonluisdev.domain.model.orderdetails.SignatureDetails
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.dataui.SignatureDetailsDataUi

fun SignatureDetails.toSignatureDetailsDataUiMapper() = SignatureDetailsDataUi(
    additionalFranchise = additionalFranchise,
    months = months,
    planType = planType
)
