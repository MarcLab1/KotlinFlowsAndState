package com.kotlinflows.ui.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kotlinflows.util.Constants

@Composable
fun MyBottomNavigationBar(navController: NavController) {

    BottomNavigation() {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Constants.BottomNavItems.forEach { item ->

            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {

                    navController.navigate(item.route) {
                        popUpTo(Constants.BottomNavItems.get(0).route) //so the back button takes us back to first, then back to the upper navigaiton (with buttons)
                        launchSingleTop = true  //no duplocates on the back stack
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.label)
                },
                label = {
                    Text(text = item.label)
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Composable
fun Navigation(nav: NavHostController) {
    var vm2: MyViewModel2 = viewModel()
    var vm3: MyViewModel3 = viewModel()

    NavHost(navController = nav, startDestination = "home")
    {
        composable("home")
        {
            Flows1()
        }
        composable("second")
        {
            Flows2(vm2)
        }
        composable("add")
        {
            Add(vm3, nav)
        }
    }
}

class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
)
