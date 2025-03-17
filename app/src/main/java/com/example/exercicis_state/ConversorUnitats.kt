package com.example.exercicis_state

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicis_state.ui.theme.teal_900
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt

@Composable
fun ConversorUnitats(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        // Write your code here

        Cap("Conversor d'unitats")

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
                    text = "EXERCICI 5",
                    fontSize = 24.sp,
                    modifier = modifier
                )
            }


            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))

            val num = title_InputNum("Introdueix un numero per fer-li la conversió", "")

            // Espai entre els textos
            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Selecciona el tipus de conversió", modifier = modifier.padding(start = 10.dp))

            // Text pel missatge del preu total
            var messageNum by rememberSaveable { mutableStateOf("") }
            val type = MyDropDownMenu()


            // Botó per verifiar el número
            Button(
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = teal_900
                ), onClick = {
                    try {
                        val num1 = parseDouble(num)
                        val convertit = when(type) {
                            "De polzada a centímetre" -> (num1 *2.54)
                            "De iarda a metre" -> (num1 *0.9144)
                            "De milla a quilòmetre" -> (num1 *1.60934)
                            "De centímetre a polzada" -> (num1 *0.393700787)
                            "De metre a iarda" -> (num1 *1.0936133)
                            "De quilòmetre a milla" -> (num1 *0.621371192)
                            else -> ""
                        }
                        messageNum = "Són: " + String.format("%.2f", convertit)

                    } catch (e: NumberFormatException) {
                        messageNum = "Introdueix un número vàlid"
                    }
                }
            ) {
                Text(text = "Conversar")
            }
            Spacer(modifier = Modifier.height(20.dp))
            // Text pel missatge del preu total
            Message(messageNum)
        }
    }
}

@Composable
fun MyDropDownMenu(): String {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val hobbies = listOf("De polzada a centímetre", "De iarda a metre", "De milla a quilòmetre",
        "De centímetre a polzada", "De metre a iarda", "De quilòmetre a milla")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth(),
            textStyle = TextStyle(color = teal_900),  // Color del text
            colors = OutlinedTextFieldDefaults.colors(
                disabledBorderColor = teal_900 // Color de la línia quan no està seleccionat

            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            hobbies.forEach { hobby ->
                DropdownMenuItem(text = { Text(text = hobby) }, onClick = {
                    expanded = false
                    selectedText = hobby
                })
            }
        }
    }
    return selectedText
}
