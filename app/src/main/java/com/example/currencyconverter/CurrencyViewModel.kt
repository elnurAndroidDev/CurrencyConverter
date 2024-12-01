package com.example.currencyconverter

import androidx.compose.runtime.State
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

    private val _fromCurrency = mutableStateOf("USD")
    val fromCurrency: State<String> = _fromCurrency

    private val _toCurrency = mutableStateOf("EUR")
    val toCurrency: State<String> = _toCurrency

    private val _amountFrom = mutableStateOf("0")
    val amountFrom: State<String> = _amountFrom

    private val _amountTo = mutableStateOf("0")
    val amountTo: State<String> = _amountTo

    fun setAmountFrom(amount: String) {
        _amountFrom.value = amount
        convert()
    }

    fun setFromCurrency(currency: String) {
        _fromCurrency.value = currency
        convert()
    }

    fun setToCurrency(currency: String) {
        _toCurrency.value = currency
        convert()
    }

    private fun convert() {
        val amount = _amountFrom.value.toDoubleOrNull() ?: 0.0
        val exchangeRate = getExchangeRate(_fromCurrency.value, _toCurrency.value)
        _amountTo.value = (amount * exchangeRate).toString()
    }

    private fun getExchangeRate(from: String, to: String): Double {
        return when (from) {
            "USD" -> when (to) {
                "EUR" -> 0.85
                "RUB" -> 75.0
                "GBP" -> 0.73
                "JPY" -> 145.0
                else -> 1.0
            }
            else -> 1.0
        }
    }
}