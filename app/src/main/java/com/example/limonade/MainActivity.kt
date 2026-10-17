package com.example.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadeApp()
        }
    }
}


@Composable
fun LimonadeApp() {
    var etape by remember { mutableIntStateOf(1) }
    var nombrePression by remember { mutableIntStateOf(0) }
    var pressionsNecessaire by remember { mutableIntStateOf(0) }

    val image = when (etape) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val texte = when (etape) {
        1 -> R.string.texte_selection_citron
        2 -> R.string.texte_presser_citron
        3 -> R.string.texte_boire_citronnade
        else -> R.string.texte_verre_vide
    }

    val description = when (etape) {
        1 -> R.string.description_citronnier
        2 -> R.string.description_citron
        3 -> R.string.description_verre_citronnade
        else -> R.string.description_verre_vide
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Limonade",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9E44C))
                .padding(16.dp)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(description),
                modifier = Modifier.clickable {
                    if (etape == 1) {
                        etape = 2
                        nombrePression = 0
                        pressionsNecessaire = (2..4).random()
                    } else if (etape == 2) {

                        nombrePression = nombrePression + 1
                        if (nombrePression>= pressionsNecessaire) {
                            etape = 3
                        }
                    } else if (etape == 3) {
                        etape = 4
                    } else {
                        etape = 1
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(texte),
                fontSize = 18.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LimonadeAppPreview() {
    LimonadeApp()
}