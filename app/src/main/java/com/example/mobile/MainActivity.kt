package com.example.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile.ui.theme.MobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally

    ) {
        Text(
            text = "Bienvenid@ $name!",
            color = Color.Gray,
            fontSize = 20.sp,
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
                .size(Dp.Infinity)
        )
        Text(
            text = "App Mobile",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(5.dp)
                .size(Dp.Infinity)
        )
        Row(
            modifier = Modifier

                .background(Color.Transparent)
                .padding(10.dp)

        ) {
            Text(
                text = "ACTIVITIES ",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .size(Dp.Infinity)
            )

        }
        Row(
            modifier = Modifier

                .background(Color.DarkGray)
                .padding(10.dp)

        ) {
            Text(
                text = "TODO",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .size(Dp.Infinity)
            )
            Text(
                text = "DONE",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .size(Dp.Infinity)
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {


    MobileTheme {
        Greeting("DIANA")
    }
}