package com.rusabi.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider

import com.rusabi.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.rusabi.firstcomposeproject.ui.theme.InstagramProfileCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            Test(viewModel = viewModel)
        }
    }
}

@Composable
fun Test(viewModel: MainViewModel) {

    FirstComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            LazyColumn {
                item {
                    Text(text = "Title", color = Color.White)
                }
                items(2) {
                    InstagramProfileCard(viewModel)
                }
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(color = Color.White)
                                .padding(4.dp),
                            painter = painterResource(id = R.drawable.ic_instagram),
                            contentDescription = null
                        )
                    }

                }
                items(200) {
                    InstagramProfileCard(viewModel)
                }
//                repeat(500) {
//                    item {
//                        InstagramProfileCard(viewModel)
//                    }
//                }

            }
        }
    }

}