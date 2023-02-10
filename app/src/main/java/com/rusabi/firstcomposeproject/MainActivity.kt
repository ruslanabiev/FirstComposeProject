package com.rusabi.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Test(viewModel: MainViewModel) {

    FirstComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {

            val models = viewModel.models.observeAsState(listOf())
//            val scope = rememberCoroutineScope()
            val lazyListState = rememberLazyListState()

            LazyColumn(
                state = lazyListState
            ) {
                items(models.value, key = { it.id } ) { model ->

                    val dismissState = rememberDismissState()

                    if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                        viewModel.delete(model)
                    }

                    SwipeToDismiss(
                        state = dismissState,
                        directions = setOf(DismissDirection.EndToStart),
                        background = {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize()
                                    .background(color = Color.Red.copy(alpha = 0.5f)),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    modifier = Modifier.padding(16.dp),
                                    text = "Delete item",
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }
                        }
                    ) {
                        InstagramProfileCard(
                            model = model,
                            onFollowedButtonClickListener = {
                                viewModel.changeFollowingStatus(it)
                            }
                        )
                    }

                }
            }

        }
    }
}

//@Composable
//fun BoxScope.FloatingActionButtonVisible(
//    scope: CoroutineScope,
//    lazyListState: LazyListState
//) {
//    FloatingActionButton(
//        modifier = Modifier
//            .align(alignment = Alignment.BottomEnd)
//            .padding(bottom = 16.dp, end = 24.dp),
//        onClick = {
//            scope.launch {
//                lazyListState.scrollToItem(0)
//            }
//        }
//    ) {
//
//    }
//
//}