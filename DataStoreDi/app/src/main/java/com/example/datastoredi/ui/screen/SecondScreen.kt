package com.example.datastoredi.ui.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SecondScreen(modifier: Modifier = Modifier, toFirstScreen: () -> Unit) {

}

@Preview
@Composable
private fun PrevSecondScreen() {
    MaterialTheme {
        SecondScreen(toFirstScreen = {})
    }
}