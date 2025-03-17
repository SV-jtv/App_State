package com.example.exercicis_state

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicis_state.ui.theme.*
import java.lang.Integer.parseInt

@Composable
fun CalculaPropina(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        // Write your code here

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
                text = "Calcula Propina",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
        // Espai
        Spacer(modifier = Modifier.height(5.dp).fillMaxWidth().background(color = teal_700))

        // Cos de l'app
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            // Espai entre els textos
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.Center
            ) {
                // Write your code here

                // Títol de l'exercici
                Text(
                    text = "EXERCICI 1",
                    fontSize = 24.sp,
                    modifier = modifier
                )
            }
            // Write your code here

            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))

            // text esplicatiu
            Text(
                text = "Menú.",
                modifier = modifier.padding(start = 10.dp)
            )

            // Espai entre els textos
            Spacer(modifier = Modifier.height(5.dp))

            // Quadre de text per introduir el número
            var menu by rememberSaveable { mutableStateOf("") }
            TextField(
                value = menu,
                onValueChange = { menu = it },
                label = { Text(text = "Introdueix el preu del menú") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            // Espai entre els textos
            Spacer(modifier = Modifier.height(10.dp))

            // text esplicatiu
            Text(
                text = "Propina",
                modifier = modifier.padding(start = 10.dp),
            )

            // Espai entre els textos
            Spacer(modifier = Modifier.height(5.dp))

            // Quadre de text per introduir el número
            var propina by rememberSaveable { mutableStateOf("") }
            TextField(
                value = propina,
                onValueChange = { propina = it },
                label = { Text(text = "introdueix un percentatge de propina") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            // Text pel missatge del preu de la propina
            var messagePropina by rememberSaveable { mutableStateOf("") }
            Text(
                text = messagePropina,
                fontSize = 30.sp,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 10.dp)
            )

            // Text pel missatge del preu total
            var messagePreu by rememberSaveable { mutableStateOf("") }
            Text(
                text = messagePreu,
                fontSize = 30.sp,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 10.dp)
            )

            // Botó per verifiar el número
            Button(modifier =Modifier,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = teal_900
                ), onClick = {
                    try {
                        val preuMenu = parseInt(menu)
                        val propina = parseInt(propina)

                        val percentatge = propina + (1 * propina)/100


                        if (preuMenu < 0) {
                            throw NumberFormatException()
                        }
                        if ((preuMenu % 2) == 0) {
                            messagePreu = percentatge.toString()
                        } else {
                            messagePreu = "Odd"
                        }
                    } catch (e: NumberFormatException) {
                        messagePreu = "String is not a number or is less than zero."
                    }
                }) {
                Text(text = "Comprovar")
            }
        }

    }

}