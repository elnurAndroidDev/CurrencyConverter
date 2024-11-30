package com.example.currencyconverter.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyInputField(
    currencies: List<String>,
    modifier: Modifier = Modifier,
    text: State<String> = mutableStateOf("0"),
    onValueChange: (String) -> Unit = {},
) {
    CurrencyOutlinedRow(
        modifier = modifier
    ) {
        TextField(
            value = text.value,
            onValueChange = {
                onValueChange(it)
            },
            textStyle = TextStyle(textAlign = TextAlign.Right),
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
            onSelectionChange = { /* Handle currency selection */ }
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
        ), modifier = Modifier.padding(32.dp)
    )
}