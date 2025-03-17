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
import java.lang.Double.parseDouble
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
        Cap("Calcula Propina")
        // Cos de l'app
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center
        ){

            // Espai entre els textos
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.Start
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

            val menu = title_InputNum("Menú", "Introdueix el preu del menú")
            val propina = title_InputNum("Propina", "Introdueix un percentatge de propina")

            // Espai entre els textos
            Spacer(modifier = Modifier.height(10.dp))

            // Text pel missatge del preu total
            var messagePreu by rememberSaveable { mutableStateOf("") }
            Message(messagePreu)

            // Text pel missatge del preu de la propina
            var messagePropina by rememberSaveable { mutableStateOf("") }
            Message(messagePropina)

            // Botó per verifiar el número
            Button(modifier =Modifier,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = teal_900
                ), onClick = {
                    try {
                        val preuMenu = parseInt(menu)
                        val preuPropina = parseDouble(propina)

                        val percentatge = (preuPropina/100) + 1
                        val preuTotal = preuMenu * percentatge

                        messagePreu = "Preu total: " + String.format("%.2f", preuTotal) + "€"
                        messagePropina = "Valor de la propina: " + String.format("%.2f", (preuTotal - preuMenu)) + "€"

                    } catch (e: NumberFormatException) {
                        messagePreu = "Introdueix els dos valors"
                    }
                }) {
                Text(text = "Calcular")
            }
        }

    }

}