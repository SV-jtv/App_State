package com.example.exercicis_state

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicis_state.ui.theme.teal_900


@Composable
fun DiceRoller(modifier: Modifier = Modifier) {
    var dice1 by remember { mutableIntStateOf(1) }
    var dice2 by remember { mutableIntStateOf(1) }
    val context = LocalContext.current  // Para mostrar el Toast

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.tapestry),
            contentDescription = "Background",
            alpha = 1f,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = R.drawable.title),
                contentDescription = "Title",
                alpha = 1f,
                modifier = Modifier.size(400.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(modifier =Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Red
                ), onClick = {
                dice1 = rollDice()
                dice2 = rollDice()
                if (dice1 == 6 && dice2 == 6) {
                    Toast.makeText(context, "JACKPOT!", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "ROLL THE DICE")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Image(
                    painter = painterResource(id = getDice(dice1)),
                    contentDescription = "Dice $dice1",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable { dice1 = rollDice() }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = getDice(dice2)),
                    contentDescription = "Dice $dice2",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable { dice2 = rollDice() }
                )
            }
        }
    }
}

// Función para lanzar un dado
fun rollDice(): Int {
    return (1..6).random()
}

// Función para obtener la imagen del dado según el número
fun getDice(number: Int): Int {
    return when (number) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}


