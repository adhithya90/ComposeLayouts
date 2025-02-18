package com.example.composelayouts.Layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NavigationSuiteScaffoldDemo(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        var selectedItemIndex by remember {
            mutableIntStateOf(0)
        }

        NavigationSuiteScaffold(
            navigationSuiteItems = {
                Screen.entries.forEachIndexed { index, screen ->
                    item(
                        selected = index == selectedItemIndex,
                        onClick = { selectedItemIndex = index },
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { screen.title }
                    )
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {
                when (selectedItemIndex) {
                    0 -> Text("Home")
                    1 -> Text("Favorites")
                    2 -> Text("Settings")
                }
            }

        }

    }
}

enum class Screen(val title: String, val icon: ImageVector) {
    HOME("Home", Icons.Filled.Home),
    FAVORITES("Favorites", Icons.Filled.Favorite),
    SETTINGS("Settings", Icons.Filled.Settings),

}

@Preview(backgroundColor = 0XFFF, showBackground = true)
@Composable
private fun NavigationSuiteScaffoldDemo() {

}