package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            FirstComposeProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val models = viewModel.models.observeAsState(listOf())
                    LazyColumn(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        items(
                            items = models.value,
                            key = { it.id }) { instagramModel: InstagramModel ->

                            val dismissThresholds = with(receiver = LocalDensity.current) {
                                LocalConfiguration.current.screenWidthDp.dp.toPx() * 0.3F
                            }
                            val dismissState = rememberSwipeToDismissBoxState(
                                positionalThreshold = { dismissThresholds },
                            )
                            SwipeToDismissBox(
                                state = dismissState,
                                enableDismissFromEndToStart = true,
                                enableDismissFromStartToEnd = false,
                                backgroundContent = {
                                    Box(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxSize()
                                            .background(Color.Red.copy(alpha = 0.7F)),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Text(
                                            modifier = Modifier.padding(16.dp),
                                            text = "Delete item",
                                            color = Color.White,
                                            fontSize = 24.sp
                                        )
                                    }
                                },
                                onDismiss = {
                                    viewModel.delete(instagramModel)
                                }
                            ) {
                                Instacard(model = instagramModel, onFollowedButtonClickListener = {
                                    viewModel.changeFollowingStatus(it)
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}
