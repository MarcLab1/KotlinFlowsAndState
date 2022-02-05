package com.kotlinflows.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.sharp.Refresh
import com.kotlinflows.ui.presentation.BottomNavItem

object Constants {

    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Flows",
            icon = Icons.Outlined.Face,
            route = "home"
        ),
        BottomNavItem(
            label = "Flows 2",
            icon = Icons.Sharp.Refresh,
            route = "second"
        ),
        BottomNavItem(
            label = "Add",
            icon = Icons.Default.Add,
            route = "add"
        ),
    )
}