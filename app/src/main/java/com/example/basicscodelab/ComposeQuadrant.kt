package com.example.basicscodelab

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class ComposeQuadrant : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(){
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            ComposeContentLayout(
                title = stringResource(id = R.string.compose_first_title),
                content = stringResource(id = R.string.compose_first_content),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposeContentLayout(
                title = stringResource(id = R.string.compose_second_title),
                content = stringResource(id = R.string.compose_second_content),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposeContentLayout(
                title = stringResource(id = R.string.compose_third_title),
                content = stringResource(id = R.string.compose_third_content),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposeContentLayout(
                title = stringResource(id = R.string.compose_fourth_title),
                content = stringResource(id = R.string.compose_fourth_content),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ComposeContentLayout(
    title: String,
    content: String,
    backgroundColor: Color,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title,
            fontWeight = FontWeight.Bold
        )
        Text(text = content, textAlign = TextAlign.Justify)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeQuadrantPreview(){
    BasicsCodelabTheme {
        ComposeQuadrantApp()
    }
}