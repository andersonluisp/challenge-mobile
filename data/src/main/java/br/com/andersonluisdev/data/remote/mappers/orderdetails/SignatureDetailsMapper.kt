package br.com.andersonluisdev.data.remote.mappers.orderdetails

import br.com.andersonluisdev.data.remote.model.orderdetails.SignatureDetailsReponse
import br.com.andersonluisdev.domain.model.orderdetails.SignatureDetails

fun SignatureDetailsReponse.toSignatureDetailsMapper() = SignatureDetails(
    additionalFranchise = additionalFranchise,
    months = months,
    planType = planType
)
