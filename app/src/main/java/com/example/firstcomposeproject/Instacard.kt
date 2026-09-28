package com.example.firstcomposeproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Instacard(modifier: Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        ShapkaKartochki()
    }
}

@Composable
private fun ShapkaKartochki() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Blue)
                .size(50.dp)
        )
        StatsColumn()
        StatsColumn()
        StatsColumn()
    }
}

@Composable
private fun StatsColumn() {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Red)
                .size(25.dp)
        )
        Box(
            modifier = Modifier
                .background(color = Color.Green)
                .size(25.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCard() {
    Instacard(modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun ShowShapkaKartochki() {
    ShapkaKartochki()
}