package com.rusabi.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.rusabi.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.rusabi.firstcomposeproject.ui.theme.InstagramProfileCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeProjectTheme() {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background)
                ) {
                    InstagramProfileCard()
//                    TestText()

                }
            }

//            TimeStable()
        }
    }
}

@Preview
@Composable
fun TestText() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color = Color.Cyan)
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = Color.Green)
                .padding(25.dp)
                .size(100.dp)
                .background(color = Color.Red)
                .padding(25.dp)
            ,
            painter = ColorPainter(color = Color.Yellow),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
    }
}