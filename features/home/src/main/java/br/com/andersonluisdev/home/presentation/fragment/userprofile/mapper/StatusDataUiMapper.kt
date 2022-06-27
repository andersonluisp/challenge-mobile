package br.com.andersonluisdev.home.presentation.fragment.userprofile.mapper

import br.com.andersonluisdev.domain.model.profile.Status
import br.com.andersonluisdev.home.presentation.fragment.userprofile.dataui.StatusDataUi

fun Status.toStatusDataUiMapper() = StatusDataUi(
    checked = checked,
    code = code,
    label = label
)
