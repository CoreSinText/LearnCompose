package com.example.datastoredi.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenFirst(modifier: Modifier = Modifier, goToScreenSecond: () -> Unit,
                userName:String, changeUserName:(newName:String)->Unit,
                saveUserName:()->Unit, storeName:String) {
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)){
            TextField(value = userName, onValueChange = { changeUserName(it) }, label = { Text("Name") })
            Text("Name: $storeName")
            Button(modifier = modifier, onClick = saveUserName) {
                Text("Save Name")
            }
        }
        Spacer(modifier.height(30.dp))
        Button(modifier = modifier, onClick = goToScreenSecond) {
            Text("Go Second Screen")
        }
    }
}

@Preview
@Composable
private fun PrevScreenFirst() {
    MaterialTheme{
        ScreenFirst(goToScreenSecond = {}, userName = "", changeUserName = {}, saveUserName = {}, storeName = "")
    }
}