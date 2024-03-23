package  com.example.mobile

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@SuppressLint("UnrememberedMutableState")
@Composable

fun FormTimer(
        duration:Int,
        onPause: () -> Unit,
        onReset:() -> Unit,
        onComplete: () -> Unit = {}
    ){

    var timeLeft by remember {
        mutableStateOf(duration)
    }

    var byPause by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1=timeLeft){
        while (timeLeft>0 && !byPause){
            delay(1000L)
            timeLeft--
        }
        onComplete()
    }

    Text(text = timeLeft.toString(),
        color= Color.LightGray,
        fontSize = 20.sp,
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(20.dp)
    )
    Button(enabled = timeLeft != 10,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        ),
        onClick = {
            byPause = false
            timeLeft = duration
            onPause()

        })
    {
        Icon(
            imageVector= Icons.Default.Refresh,
            contentDescription=null
        )
        Spacer(modifier = Modifier
            . size(16.dp)
        )
        Text(text="Restart!")

    }

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        ),
        onClick = {
            byPause=true
            onReset()
        })
    {
        Icon(
            imageVector= Icons.Default.Warning,
            contentDescription=null
        )
        Spacer(modifier = Modifier
            . size(16.dp)
        )
        Text(text="Pause!")

    }
}
@Composable
fun PersonListObject() {


var isFormEnabled by remember {
    mutableStateOf(true)
}

    var name by remember {
        mutableStateOf("")
    }
    var age by remember{
        mutableStateOf("")
    }

    var names by remember {
        mutableStateOf(listOf<Person>())
    }



    var context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Lista de personas",
            fontSize = 20.sp,
            modifier = Modifier
                .background(Color.White)
        )
        FormTimer(
            duration = 5,
            onReset ={
                isFormEnabled=true
            },
            onPause = {
                isFormEnabled=false
            }

        )

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = name,
                placeholder = { Text(text = "Ingrese un nombre") },
                onValueChange = { text -> name = text }
            )
            Spacer(modifier = Modifier.size(16.dp))
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = age,
                placeholder = { Text(text = "Ingrese la edad") },
                onValueChange = { text -> age = text },
                //keyboardOptions = KeyboardType.Number

            )

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                enabled = name.isNotBlank() && age.isNotBlank(),
                onClick = {
                        names = names + Person(name, age.toInt())
                        name = ""
                        age = ""
                        Toast.makeText(
                            context,
                            "Persona agregada!",
                            Toast.LENGTH_SHORT
                        ).show()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar nueva persona"
                )
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        LazyColumn(userScrollEnabled = true) {
            items(names) { person ->
                Text(text = "${person.name} - ${person.age} años")
            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun PersonListObj() {
    PersonListObject()
}