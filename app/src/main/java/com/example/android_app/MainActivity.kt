package com.example.android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_app.ui.theme.AndroidappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}

@Composable
fun CounterApp() {
    var counter by remember { mutableStateOf(0) }
    val names = listOf("John", "Jane", "Doe")

    data class User(val id: Int, val name: String, val age: Int)
    val users = listOf(
        User(id = 1, name = "John", age = 30),
        User(id = 2, name = "Jane", age = 25),
        User(id = 3, name = "Doe", age = 22)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="States and Variables", fontWeight = FontWeight.Bold, modifier=Modifier.padding(16.dp).fillMaxWidth())
        Text(text = "Counter: $counter", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { counter++ }) {
            Text(text = "Increment")
        }

        Button(onClick = { counter-- }) {
            Text(text = "Decrement")
        }

        Button(onClick = {counter = 0}) {
            Text(text = "Reset")
        }

        Column(){
            Spacer(Modifier.height(8.dp))
            Text(text="Mapping Strings", fontWeight = FontWeight.Bold, modifier=Modifier.padding(16.dp))
            names.forEach{ name ->
                Box(Modifier.background(Color.Green).padding(10.dp).fillMaxWidth()) {
                    Text(name, textAlign = TextAlign.Center, modifier=Modifier.fillMaxWidth())
                }
                Spacer(Modifier.height(4.dp))
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    AndroidappTheme {
        CounterApp()
    }
}
