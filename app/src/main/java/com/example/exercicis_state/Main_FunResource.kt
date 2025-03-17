package com.example.exercicis_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicis_state.ui.theme.Exercicis_stateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercicis_stateTheme {
                //CalculaPropina(modifier = Modifier)
                //IMC(modifier = Modifier)
                //NumeroSecret(modifier = Modifier)
                //NumeroSecret2(modifier = Modifier)
                //ConversorUnitats(modifier = Modifier)
                //LemonadeApp()
                DiceRoller(modifier = Modifier)
            }
        }
    }
}


@Composable
fun LemonadeApp() {
    var lemonadeState by remember { mutableStateOf("select") }
    var lemonSize by remember { mutableIntStateOf(-1) }
    var squeezeCount by remember { mutableIntStateOf(-1) }
    val lemonTree = LemonTree()

    fun clickLemonImage() {
        when (lemonadeState) {
            "select" -> {
                squeezeCount = 0
                lemonSize = lemonTree.pick()
                lemonadeState = "squeeze"
            }
            "squeeze" -> {
                lemonSize--
                squeezeCount++
                if (lemonSize == 0) lemonadeState = "drink"
            }
            "drink" -> {
                lemonSize = -1
                lemonadeState = "restart"
            }
            "restart" -> {
                lemonadeState = "select"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageRes = when (lemonadeState) {
            "select" -> R.drawable.lemon_tree
            "squeeze" -> R.drawable.lemon_squeeze
            "drink" -> R.drawable.lemon_drink
            "restart" -> R.drawable.lemon_restart
            else -> R.drawable.lemon_tree
        }

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Lemon State",
            modifier = Modifier
                .size(200.dp)
                .clickable { clickLemonImage() }
        )


        val textAction = when (lemonadeState) {
            "select" -> "Agafa una llimona"
            "squeeze" -> "Esprem la llimona"
            "drink" -> "Beu-te la llimonada"
            "restart" -> "Torna a fer una llimonada"
            else -> ""
        }

        Text(
            text = textAction,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )

        if (lemonadeState == "squeeze") {
            Text(
                text = "$squeezeCount",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


class LemonTree {
    fun pick(): Int {
        return (1..4).random()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Exercicis_stateTheme {
        //CalculaPropina(modifier = Modifier)
        //IMC(modifier = Modifier)
        //NumeroSecret(modifier = Modifier)
        //NumeroSecret2(modifier = Modifier)
        //ConversorUnitats(modifier = Modifier)
        //LemonadeApp()
        DiceRoller(modifier = Modifier)
    }
}