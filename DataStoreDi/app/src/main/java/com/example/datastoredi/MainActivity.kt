package com.example.datastoredi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.datastoredi.ui.screen.FirstScreen
import com.example.datastoredi.ui.screen.SecondScreen
import com.example.datastoredi.ui.theme.DataStoreDiTheme
import kotlinx.serialization.Serializable

@Serializable
object ScreenFirst

@Serializable
object ScreenSecond

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataStoreDiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DataStoreHillApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DataStoreHillApp(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenFirst) {
        composable<ScreenFirst> {
            FirstScreen(modifier = modifier)
        }
        composable<ScreenSecond> {
            SecondScreen(modifier = modifier)
        }
    }
}