package com.shabeen07.my_notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shabeen07.my_notes.models.NoteDto
import com.shabeen07.my_notes.ui.theme.MyNotesTheme
import com.shabeen07.my_notes.ui.theme.Typography

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    var notesList: MutableList<NoteDto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNotesTheme {
                navController = rememberNavController()
                SetUpNavGraph(navController = navController, notesList)
            }
        }
    }
}

@Composable
fun MainScreen(innerPadding: PaddingValues) {
    var value by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(1f),
            color = MaterialTheme.colorScheme.primary
        ) {}
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(1f),
            color = MaterialTheme.colorScheme.secondary
        ) {}
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.tertiary),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { value = !value }) {
                    Text(text = "Click Me $value")
                }
                Text(
                    text = "Hello",
                    style = Typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onTertiary)
                )
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNotesTheme {
        MainScreen(PaddingValues())
    }
}