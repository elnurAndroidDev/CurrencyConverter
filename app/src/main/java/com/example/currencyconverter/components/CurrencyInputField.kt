package com.example.currencyconverter.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyInputField(
    currencies: List<String>,
    amount: String,
    currency: String,
    modifier: Modifier = Modifier,
    onAmountChange: (String) -> Unit = {},
    onCurrencyChange: (String) -> Unit = {}
) {
    CurrencyOutlinedRow(
        modifier = modifier
    ) {
        TextField(
            value = amount,
            onValueChange = {
                onAmountChange(it)
            },
            textStyle = TextStyle(textAlign = TextAlign.Right),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.weight(1f)
        )
        CurrencyDropDownMenu(
            currencies = currencies,
            selectedCurrency = currency,
            onSelectionChange = { onCurrencyChange(it) }
        )
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun CurrencyInputLayoutPreview() {
    CurrencyInputField(
        listOf(
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
        ), currency = "USD", amount = "0", modifier = Modifier.padding(32.dp)
    )
}