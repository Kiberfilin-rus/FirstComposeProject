package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                //TablicaUmnojenia(modifier = Modifier.padding(innerPadding))
                ShapkaKartochki(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}


@Composable
fun TablicaUmnojenia(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        for (i in 1..9) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                for (j in 1..9) {
                    val boxBackground =
                        if ((i + j) % 2 == 0) {
                            Color.Yellow
                        } else {
                            Color.Cyan
                        }
                    Box(
                        modifier = Modifier
                            .background(boxBackground)
                            .fillMaxHeight()
                            .weight(1f)
                            .border(width = 1.dp, color = Color.Red),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = (i * j).toString())
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTable() {
    TablicaUmnojenia(modifier = Modifier)
}