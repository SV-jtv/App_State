package com.example.exercicis_state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicis_state.ui.theme.teal_900
import java.lang.Integer.parseInt

@Composable
fun NumeroSecret(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        // Write your code here

        Cap("Endevina el número secret")

        // Cos de l'app
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Write your code here

            // Espai entre els textos
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(color = Color.White),
                horizontalArrangement = Arrangement.Start,
            ) {
                // Write your code here

                // Títol de l'exercici
                Text(
                    text = "EXERCICI 3",
                    fontSize = 24.sp,
                    modifier = modifier
                )
            }


            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))

            var numSecret by rememberSaveable { mutableIntStateOf((0..100).random()) }
            val num = title_InputNum("Numero", "Introdueix un numero")


            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))

            // Text pel missatge del preu total
            var messageNum by rememberSaveable { mutableStateOf("") }
            Message(messageNum)


            // Botó per verifiar el número
            Button(
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = teal_900
                ), onClick = {
                    try {
                        val num1 = parseInt(num)

                        messageNum = when {
                            num1 > numSecret -> "El número que busques és més petit"
                            num1 < numSecret -> "El número que busques és més gran"
                            else -> {
                                numSecret = (0..100).random() // Reiniciem el joc
                                "Has encertat!"
                            }
                        }
                    } catch (e: NumberFormatException) {
                        messageNum = "Introdueix un número vàlid"
                    }
                }
            ) {
                Text(text = "Comprovar número")
            }
        }
    }
}