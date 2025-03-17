package com.example.exercicis_state

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicis_state.ui.theme.teal_900
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.time.Year
import kotlin.math.pow

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DiceRoller(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        // Write your code here

        Cap("Calcula l'IMC")

        // Cos de l'app
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
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
                    text = "EXERCICI 2",
                    fontSize = 24.sp,
                    modifier = modifier
                )
            }


            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))

            val nom = title_InputStri("Nom", "Introdueix el teu nom")
            val naixement = title_InputNum("Any de naixement", "Introdueix el teu any de naixement ")
            val alcada = title_InputNum("Alçada", "Introdueix la teva alçada")
            val pes = title_InputNum("Pes", "Introdueix el teu pes")

            /*val pattern = remember { Regex("^\\d+\$") }
            TextField(
               value = myText,
               onValueChange = {
                   if (it.isEmpty() || it.matches(pattern)) myText = it
               },
               label = { Text(text = "Enter your year of birth") },
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
             */


            // Espai entre els textos
            Spacer(modifier = Modifier.height(10.dp))

            // Text pel missatge del preu total
            var messageNomEdad by rememberSaveable { mutableStateOf("") }
            Message(messageNomEdad)

            // Text pel missatge del preu de la propina
            var messageIMC by rememberSaveable { mutableStateOf("") }
            Message(messageIMC)


            // Botó per verifiar el número
            Button(modifier =Modifier,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = teal_900
                ), onClick = {
                    try {
                        val any = parseInt(naixement)
                        val pesNum = parseDouble(pes)
                        val height = parseDouble(alcada)

                        val imc = (pesNum/height.pow(2.0))
                        val age = Year.now().value - any

                        messageNomEdad = ("$nom $age")
                        messageIMC = when {
                            imc<18.5 -> "IMC insuficient"
//                            18.5>imc &&
                            imc<24.9 -> "IMC normal"
                            25<imc && imc<50 -> "IMC amb sobrepès"
                            50<imc -> "IMC amb obesitat"

                            else -> {""}
                        }

                    } catch (e: NumberFormatException) {
                        messageNomEdad = "Introdueix tots els valors"
                    }
                }) {
                Text(text = "Calcular IMC")
            }
        }

    }

}