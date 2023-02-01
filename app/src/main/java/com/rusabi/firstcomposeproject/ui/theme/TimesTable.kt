package com.rusabi.firstcomposeproject.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TimeStable() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        for (i in 1..9) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(50.dp)
                    .weight(1f)
            ) {
                for (j in 1..9) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .border(width = 1.dp, color = Color.DarkGray)
                            .background(color = if ((j + i) % 2 == 0) Color.Yellow else Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "${i * j}")
                    }
                }
            }
        }
    }

}