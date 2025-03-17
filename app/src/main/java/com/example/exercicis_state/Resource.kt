package com.example.exercicis_state

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicis_state.ui.theme.teal_700


@Composable
fun Cap(text: String, modifier: Modifier = Modifier) {

    // Espai principal
    Spacer(modifier = Modifier.height(30.dp).fillMaxWidth().background(color = teal_700))

    // Bloc on va la imatge i el títol de l'app
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = teal_700),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Write your code here

        // Imatge del títol de l'app
        Image(painter = painterResource(id = R.drawable.itb_logo), contentDescription = "ITB")

        // Text del títol de l'app
        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
    // Espai
    Spacer(modifier = Modifier.height(5.dp).fillMaxWidth().background(color = teal_700))
}

@Composable
fun title_InputNum(title: String, label: String, modifier: Modifier = Modifier): String {

    // text esplicatiu
    Text(
        text = title,
        modifier = modifier.padding(start = 10.dp)
    )

    // Espai entre els textos
    Spacer(modifier = Modifier.height(5.dp))

    // Quadre de text per introduir el número
    var nom by remember { mutableStateOf("") }
    TextField(
        value = nom,
        onValueChange = { nom = it },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    Spacer(modifier = Modifier.height(10.dp))
    return nom
}
@Composable
fun title_InputStri(title: String, label: String, modifier: Modifier = Modifier): String {

    // text esplicatiu
    Text(
        text = title,
        modifier = modifier.padding(start = 10.dp)
    )

    // Espai entre els textos
    Spacer(modifier = Modifier.height(5.dp))

    // Quadre de text per introduir el número
    var nom by remember { mutableStateOf("") }
    TextField(
        value = nom,
        onValueChange = { nom = it },
        label = { Text(text = label) }
    )
    Spacer(modifier = Modifier.height(10.dp))
    return nom
}

@Composable
fun Message(text: String, modifier: Modifier = Modifier) {
    // Text pel missatge
    Text(
        text = text,
        fontSize = 20.sp,
        modifier = modifier
            .padding(start = 10.dp)
    )
    // Espai entre els textos
    Spacer(modifier = Modifier.height(10.dp))
}