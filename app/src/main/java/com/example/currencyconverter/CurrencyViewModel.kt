package com.example.currencyconverter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CurrencyViewModel : ViewModel() {
    val currencies = listOf(
        "USD",
        "EUR",
        "JPY",
        "GBP",
        "AUD",
        "CAD",
        "CHF",
        "CNY",
        "HKD",
        "NZD",
        "RUB",
        "SGD",
        "ZAR"
    )

    private val _fromCurrency = mutableStateOf("")
    val fromCurrency: State<String> = _fromCurrency

    private val _toCurrency = mutableStateOf("")
    val toCurrency: State<String> = _toCurrency

    private val _amountFrom = mutableStateOf("0")
    val amountFrom: State<String> = _amountFrom

    private val _amountTo = mutableStateOf("0")
    val amountTo: State<String> = _amountTo

    fun setFromCurrency(currency: String) {
        _fromCurrency.value = currency
    }

    fun setToCurrency(currency: String) {
        _toCurrency.value = currency
    }

    fun convert(amountStr: String) {
        val amount = amountStr.toIntOrNull() ?: 0
        _amountFrom.value = amount.toString()
        _amountTo.value = (amount * 2).toString()
    }
}