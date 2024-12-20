package com.example.currencyconverter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.currencyconverter.components.CurrencyInputField

@Composable
fun ConverterScreen(modifier: Modifier = Modifier) {

    val viewModel: CurrencyViewModel = viewModel()
    val currencies = viewModel.currencies
    val amountFrom by viewModel.amountFrom
    val amountTo by viewModel.amountTo
    val fromCurrency by viewModel.fromCurrency
    val toCurrency by viewModel.toCurrency

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CurrencyInputField(
            currencies = currencies,
            amount = amountFrom,
            currency = fromCurrency,
            onAmountChange = {
                viewModel.setAmountFrom(it)
            },
            onCurrencyChange = {
                viewModel.setFromCurrency(it)
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        CurrencyInputField(
            currencies = currencies,
            amount = amountTo,
            currency = toCurrency,
            onAmountChange = {},
            onCurrencyChange = {
                viewModel.setToCurrency(it)
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ConverterScreenPreview() {
    ConverterScreen()
}