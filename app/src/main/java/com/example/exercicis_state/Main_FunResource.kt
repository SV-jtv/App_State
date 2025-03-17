package com.example.exercicis_state

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exercicis_state.ui.theme.Exercicis_stateTheme

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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

@RequiresApi(Build.VERSION_CODES.O)
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