package com.example.tarjetapresentacion


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TarjetaPresentacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TarjetaPresentacion(
                        nombre = "Nathaly Estefania Quinatoa Toapanta",
                        carrera ="Sistemas y Gestion de Data",
                        mensaje = "Asignatura de Aplicaciones Moviles",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TarjetaPresentacion(nombre: String, carrera: String, mensaje: String,modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .fillMaxSize()
        .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Elementos de la tarjeta
        Text(
            text = nombre,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = carrera,
            fontSize = 18.sp,
            color = colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = mensaje,
            textAlign = TextAlign.Center
        )

    }}
@Preview(showBackground = true)
@Composable
fun TarjetaPresentacionPreview() {
    TarjetaPresentacionTheme {
        TarjetaPresentacion (nombre = "Nathaly Estefania Quinatoa Toapanta",
            carrera ="Sistemas y Gestion de Data",
            mensaje = "Asignatura de Aplicaciones Moviles",
           )
    }
}