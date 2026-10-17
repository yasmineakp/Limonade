package com.example.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val etape = remember { mutableStateOf(1) }
    val clicsRestants = remember { mutableStateOf(0) }


    val image = when (etape.value) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val texte = when (etape.value) {
        1 -> R.string.texte_selection_citron
        2 -> R.string.texte_presser_citron
        3 -> R.string.texte_boire_citronnade
        else -> R.string.texte_verre_vide
    }

    val description = when (etape.value) {
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
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFFC3ECD2))
                    .border(2.dp, Color(0xFF69CDD8), RoundedCornerShape(24.dp))
                    .clickable {
                        if (etape.value == 1) {

                            clicsRestants.value = (2..4).random()
                            etape.value = 2
                        } else if (etape.value == 2) {
                            clicsRestants.value = clicsRestants.value - 1
                            if (clicsRestants.value <= 0) {
                                etape.value = 3
                            }
                        } else if (etape.value == 3) {
                            etape.value = 4
                        } else {
                            etape.value = 1
                        }
                    }
                    .padding(24.dp)
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