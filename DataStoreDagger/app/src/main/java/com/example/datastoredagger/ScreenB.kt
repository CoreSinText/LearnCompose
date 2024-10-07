package com.example.datastoredagger

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun ScreenB(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    var name by remember { mutableStateOf("") }
    val savedName by viewModel.nameFlow.observeAsState(initial = "No name saved")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.saveName(name) }) {
            Text(text = "Save Name")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Saved Name: $savedName")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("A") }) {
            Text(text = "Go to Screen A")
        }
    }
}
