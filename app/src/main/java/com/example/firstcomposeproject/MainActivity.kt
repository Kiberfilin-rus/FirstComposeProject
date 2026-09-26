package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Greeting(
                    name = "Android",
                    age = 10,
                    modifier = Modifier.padding(innerPadding)
                )
                /*Text(
                    text = "Hello Android",
                    modifier = Modifier.padding(innerPadding)
                )*/
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    age: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name! Тебе $age лет.",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstComposeProjectTheme {
        Greeting(
            name ="Android",
            age = 7)
    }
}