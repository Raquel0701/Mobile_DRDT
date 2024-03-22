package  com.example.mobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


@Composable
fun TapCounter(){
    var counter by remember {
        mutableIntStateOf(0)
    }

    var myText = remember {
        mutableStateListOf("dg")
    }
    Column(  modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally) {
        if(
           counter==10
        ){
            Text("¡Llegaste!", fontSize = 50.sp)
        }else{

        }

        Text(text=counter.toString(), fontSize = 30.sp)
        Button(
            enabled = counter != 10,
            onClick = {
            counter ++
            println("Button tapped $counter")
        })
        {
            Icon(
                imageVector= Icons.Default.Add,
                contentDescription=null
            )
            Spacer(modifier = Modifier
                . size(16.dp)
            )
            Text(text="Tap me!")
            
        }
        Button(enabled = counter != 0,
            colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
            ),
            onClick = {

            counter = 0
            println("Reset $counter")

        })
        {
            Icon(
                imageVector= Icons.Default.Refresh,
                contentDescription=null
            )
            Spacer(modifier = Modifier
                . size(16.dp)
            )
            Text(text="Reset!")

        }
    }

}
@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun TapPreview() {
    TapCounter()
}