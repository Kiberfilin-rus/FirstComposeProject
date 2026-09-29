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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme

@Composable
fun Instacard(modifier: Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
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

@Preview(name = "Instacard Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Instacard Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShowCard() {
    FirstComposeProjectTheme {
        Instacard(modifier = Modifier)
    }
}

@Preview(name = "Шапка Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Шапка Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShowShapkaKartochki() {
    FirstComposeProjectTheme {
        ShapkaKartochki()
    }
}