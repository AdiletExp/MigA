package com.example.miga.models

data class CurrencyModel(
    val purchase: Double,
    val currency: String,
    val currencyExtension: String?,
    val sale: Double,
)
