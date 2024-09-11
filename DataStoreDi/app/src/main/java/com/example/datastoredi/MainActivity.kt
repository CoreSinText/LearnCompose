package com.example.datastoredi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.datastoredi.ui.screen.ScreenFirst
import com.example.datastoredi.ui.screen.ScreenSecond
import com.example.datastoredi.ui.theme.DataStoreDITheme
import com.example.datastoredi.viewModel.ViewModelScreenFirst
import com.example.datastoredi.viewModel.ViewModelScreenSecond
import kotlinx.serialization.Serializable

@Serializable
object RouteScreenFirst

@Serializable
object RouteScreenSecond

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataStoreDITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DataStoreDIApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DataStoreDIApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModelScreenFirst:ViewModelScreenFirst = viewModel(factory = ViewModelScreenFirst.Factory)
    val uiStateScreenFirst by viewModelScreenFirst.uiState.collectAsState()
    val uiStateUserDataStore by viewModelScreenFirst.uiStateUserDataStore.collectAsState()


    NavHost(navController, startDestination = RouteScreenFirst) {
        composable<RouteScreenFirst> {
            ScreenFirst(goToScreenSecond = {navController.navigate(RouteScreenSecond)},
                userName = uiStateScreenFirst.name, changeUserName = viewModelScreenFirst::changeName,
                saveUserName =  viewModelScreenFirst::saveName,
                storeName = uiStateUserDataStore.name)
        }
        composable<RouteScreenSecond> {
            ScreenSecond(goToScreenFirst = {navController.navigate(RouteScreenFirst)}, currentUserName = "as")
        }
    }

}