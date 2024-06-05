package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme


class BusinessCardApplication : ComponentActivity() {

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
                    UserProfileApplication()
                }
            }
        }
    }
}

@Composable
fun UserProfileApplication() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD6E2D6))
            .padding(bottom = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val logo = painterResource(id = R.drawable.android_logo)
        Image(
            painter = logo,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentDescription = null,
        )
        Text(
            text = stringResource(id = R.string.user_name),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.user_intro),
            fontSize = 15.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomRowInfo(
            painterIcon = painterResource(id = androidx.core.R.drawable.ic_call_answer_low),
            content = stringResource(id = R.string.user_phone),
        )
        BottomRowInfo(
            painterIcon = painterResource(id = androidx.core.R.drawable.ic_call_answer_video),
            content = stringResource(id = R.string.user_contact),
        )
        BottomRowInfo(
            painterIcon = painterResource(id = androidx.core.R.drawable.ic_call_decline),
            content = stringResource(id = R.string.user_email),
        )
    }
}


@Composable
fun BottomRowInfo(painterIcon: Painter, content: String) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            painter = painterIcon,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = content, modifier = Modifier.padding(start = 5.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardApplicationPreview() {
    BasicsCodelabTheme {
        UserProfileApplication()
    }
}
