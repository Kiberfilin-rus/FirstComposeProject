package com.example.firstcomposeproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme

@Composable
fun Instacard(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val isFollowed: State<Boolean> = viewModel.isFollowing.observeAsState(false)
    Card(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
    ) {
        ShapkaKartochki()
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Nelzyagram",
                fontFamily = FontFamily.Cursive,
                fontSize = 32.sp
            )
            Text(
                text = "#Mne_tu",
                fontSize = 14.sp
            )
            Text(
                text = "www.leningrad.spb.ru",
                fontSize = 14.sp
            )
            FollowButton(isFollowed = isFollowed) {
                viewModel.changeFollowingStatus()
            }
        }
    }
}

@Composable
private fun FollowButton(
    isFollowed: State<Boolean>,
    clickListener: () -> Unit
) {
    Button(
        onClick = { clickListener() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed.value) {
                MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.5f
                )
            } else {
                MaterialTheme.colorScheme.primary
            }
        )
    ) {
        if (isFollowed.value) {
            Text(text = "Unfollow")
        } else {
            Text(text = "Follow")
        }
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
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.sharp_3d_rotation_24),
            contentDescription = "Иконка",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
        )
        StatsColumn(title = "Posts", value = "6,950")
        StatsColumn(title = "Followers", value = "436M")
        StatsColumn(title = "Following", value = "76")
    }
}

@Composable
private fun StatsColumn(title: String, value: String) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(name = "Instacard Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Instacard Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShowCard() {
    FirstComposeProjectTheme {
        Instacard(modifier = Modifier, viewModel = MainViewModel())
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