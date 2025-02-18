package com.example.composelayouts.Layouts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi

import androidx.compose.foundation.layout.FlowRow

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.composelayouts.R
import com.example.composelayouts.ui.theme.ComposeLayoutsTheme
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun RowColumnDemo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .align(Alignment.CenterHorizontally)

        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .align(Alignment.CenterHorizontally)
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Magenta)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
private fun RowColumnDemoPreview() {
    ComposeLayoutsTheme {
        RowColumnDemo()
    }
}

@Composable
fun BoxTry() {
    Box(contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(R.drawable.image1),
            contentDescription = ""
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent, Color.Black
                        )
                    )
                )

        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = Color.Yellow,
            )
        }


    }

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF
)
@Composable
private fun BoxTryPreview() {
    ComposeLayoutsTheme {
        BoxTry()
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyLayoutDemo() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        stickyHeader {
            Text(
                text = "List of items", modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
        items(count = 100) { i ->
            Text("Item $i", modifier = Modifier.padding(2.dp))
        }
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun LazyLayoutDemoPreview() {
    ComposeLayoutsTheme {
        LazyLayoutDemo()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo() {
    FlowRow(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        maxItemsInEachRow = 5
    ) {
        for (i in 1..40) {
            AssistChip(
                onClick = {},
                label = { Text(text = "Chip $i") }
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun FlowLayoutDemoPreview() {
    ComposeLayoutsTheme {
        FlowLayoutDemo()

    }
}

@Composable
fun LazyGridDemo() {
    LazyVerticalGrid(columns = GridCells.Adaptive(100.dp)) {
        items(count = 100) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .background(Color(Random.nextInt()))
            )
        }
    }
}

@PreviewScreenSizes
@Preview(showBackground = true, backgroundColor = 0xFF)
@Composable
private fun LazyGridDemoPreview() {
    ComposeLayoutsTheme {
        LazyGridDemo()
    }
}



@Composable
fun LazyStaggeredGridDemo() {
    val windowClass = currentWindowAdaptiveInfo().windowSizeClass
    val column = when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            2
        }

        WindowWidthSizeClass.MEDIUM -> {
            2
        }

        WindowWidthSizeClass.EXPANDED -> {
            5
        }

        else -> {
            3
        }
    }
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(column)
    ) {
        items(100) {
            Box(
                modifier = Modifier
                    .height(
                        height = Random.nextInt(100..290).dp
                    )
                    .background(Color(Random.nextInt()))
                    .clip(RoundedCornerShape(20.dp))
            )
        }
    }
}

@PreviewScreenSizes
@Preview
    (showBackground = true, backgroundColor = 0xFF)
@Composable
private fun LazyStaggeredGridPreview() {
    ComposeLayoutsTheme {
        LazyStaggeredGridDemo()
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldLayoutDemo() {
    val snackBarState = remember {
        SnackbarHostState()
    }

    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Top App Bar Scaffold")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors()

            )
        },
        bottomBar = {
            BottomAppBar {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Back",
                        )
                    },
                    label = {
                        Text("Account")
                    }

                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Back",
                        )
                    },
                    label = {
                        Text("Search")
                    }

                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = "Back",
                        )
                    },
                    label = {
                        Text("Account")
                    }

                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    snackBarState.showSnackbar("Hello")
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        snackbarHost = {
            SnackbarHost(snackBarState)
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(padding)
        ) {
            Text("Let's start a new thing!", modifier = Modifier.align(Alignment.BottomStart))
        }
    }
}


@Preview
@Composable
private fun ScaffoldLayoutDemoPreview() {
    ComposeLayoutsTheme {
        ScaffoldLayoutDemo()
    }

}

@Composable
fun WindowSizeClassDemo() {
    val windowClass = currentWindowAdaptiveInfo().windowSizeClass

    Scaffold() { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (windowClass.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT -> {
                    LazyStaggeredGridDemo()
                }

                WindowWidthSizeClass.MEDIUM -> {
                    LazyStaggeredGridDemo()
                }

                WindowWidthSizeClass.EXPANDED -> {
                    LazyStaggeredGridDemo()
                }
            }
        }

    }


}

@PreviewScreenSizes
@Preview(
    showBackground = true,
    backgroundColor = 0XFF
)
@Composable
private fun WindowSizeClassDemoPreview() {
    ComposeLayoutsTheme {
        WindowSizeClassDemo()
    }

}





