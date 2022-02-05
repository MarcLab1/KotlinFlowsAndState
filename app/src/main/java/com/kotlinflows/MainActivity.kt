package com.kotlinflows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kotlinflows.ui.presentation.MyBottomNavigationBar
import com.kotlinflows.ui.presentation.Navigation
import com.kotlinflows.ui.theme.KotlinFlowsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinFlowsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var nav = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            MyBottomNavigationBar(navController = nav)
                        }, content = {
                            Navigation(nav)
                        },
                    )
                }
            }
        }
    }
}

