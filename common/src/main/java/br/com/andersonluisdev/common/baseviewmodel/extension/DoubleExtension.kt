package br.com.andersonluisdev.common.baseviewmodel.extension

import java.text.NumberFormat
import java.util.Locale

private const val LANGUAGE = "pt"
private const val COUNTRY = "BR"

fun Double.formatMoney(): String =
    NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY)).format(this)
