package br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.mapper

import br.com.andersonluisdev.domain.model.profile.Order
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.dataui.SubscriptionDataUi

fun Order.toSubscriptionDataUiMapper(): SubscriptionDataUi = SubscriptionDataUi(
    orderId = orderId,
    subModelName = subModelName
)
