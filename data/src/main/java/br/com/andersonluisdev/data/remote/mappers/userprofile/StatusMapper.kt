package br.com.andersonluisdev.data.remote.mappers.userprofile

import br.com.andersonluisdev.data.remote.model.profile.StatusResponse
import br.com.andersonluisdev.domain.model.profile.Status

fun StatusResponse.toStatusMapper() = Status(
    checked = checked,
    code = code,
    label = label
)
