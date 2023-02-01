package com.rusabi.firstcomposeproject.ui.theme

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rusabi.firstcomposeproject.R

@Composable
fun InstagramProfileCard() {

    Card(
        modifier = Modifier.padding(8.dp),
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    )
    {
        Column(

        ) {

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
                        .clip(CircleShape)
                        .background(color = Color.White)
                        .padding(4.dp),
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = null
                )

                UserStatistics(title = "Posts", value = "6950")
                UserStatistics(title = "Followers", value = "436M")
                UserStatistics(title = "Following", value = "76")
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
//                val mContext = LocalContext.current
                Text(
                    text = "Instagram",
                    fontSize = 32.sp,
                    fontFamily = FontFamily.Cursive,
                )
                Text(
                    text = "#YoursToMake",
                    fontSize = 14.sp,
                )
                Text(
                    text = "www.facebook.com/emotional_health",
                    fontSize = 14.sp,
                )
                Button(
                    onClick = {
//                        Toast.makeText(
//                            mContext,
//                            "This is a Sample Toast",
//                            Toast.LENGTH_LONG
//                        ).show()
                    }
                ) {
                    Text(text = "Follow")
                }
            }
        }

    }
}

@Composable
private fun UserStatistics(title: String, value: String) {

    Column(
        modifier = Modifier
            .height(80.dp),
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

@Preview
@Composable
fun PreviewCardLite() {
    FirstComposeProjectTheme(darkTheme = false) {
        InstagramProfileCard()
    }
}

@Preview
@Composable
fun PreviewCardDark() {
    FirstComposeProjectTheme(darkTheme = true) {
        InstagramProfileCard()
    }
}