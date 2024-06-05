package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicscodelab.ui.theme.ArticleLayoutTheme
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme


class ArticleLayout : ComponentActivity() {

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
                    articleLayout(
                        stringResource(R.string.title),
                        stringResource(id = R.string.first_text),
                        stringResource(id = R.string.second_text),
                        Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun articleLayout(title: String, firstText: String, secondText: String, modifier: Modifier) {
    val bg = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
        Image(painter = bg, contentDescription = null)
        Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(
            text = firstText,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = secondText,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticleLayoutPreview() {
    ArticleLayoutTheme {
        articleLayout(
            stringResource(R.string.title),
            stringResource(id = R.string.first_text),
            stringResource(id = R.string.second_text),
            Modifier.fillMaxSize()
        )
    }
}