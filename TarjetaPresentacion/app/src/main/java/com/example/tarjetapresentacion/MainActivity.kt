package com.example.tarjetapresentacion


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d("TarjetaPresentacion", "Nombre: Nathaly Estefania Quinatoa Toapanta")

        setContent {
            TarjetaPresentacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    PantallaReportes(
                        modifier = Modifier.padding(innerPadding)
                    )


                }
            }
        }
    }
}

@Composable
fun TarjetaPresentacion(
    nombre: String,
    carrera: String,
    mensaje: String,
    ciclo: Int = 5,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF003CC7))
            .padding(24.dp),


        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        //Elementos de la tarjeta
        Text(
            text = nombre,
            fontSize = 32.sp,
            lineHeight = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = carrera,
            fontSize = 24.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nivel $ciclo",
            fontSize = 18.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = mensaje,
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )

    }
}

fun colorPrioridad(prioridad: String): Color = when (prioridad) {
    "Alta" -> Color.Red
    "Media" -> Color(0xFFFFA000)
    "Baja" -> Color(0xFF2E7D32)
    "Medios de comunicación" -> Color(0xFFFFA000)
    "Urgente" -> Color.Red



    else -> {
        Log.w("Reportes", "Prioridad desconocida: $prioridad")
        Color.Gray
    }
}

@Composable
fun TarjetaReporte(
    titulo: String,
    ubicacion: String,
    prioridad: String,
    estado: String = "Pendiente"
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Ubicación: $ubicacion",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Prioridad: $prioridad",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorPrioridad(prioridad)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Estado: $estado",
                fontSize = 16.sp
            )
        }
    }
}


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

@Preview(showBackground = true)
@Composable
fun TarjetaReportePreview() {
    TarjetaPresentacionTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TarjetaReporte(
                titulo = "Falla en los equipos de computación",
                ubicacion = "Laboratorio 1",
                prioridad = "Alta"
            )

            Spacer(modifier = Modifier.height(12.dp))

            TarjetaReporte(
                titulo = "Problema de iluminación",
                ubicacion = "Aula 203",
                prioridad = "Media"
            )

            Spacer(modifier = Modifier.height(12.dp))

            TarjetaReporte(
                titulo = "Solicitud de limpieza",
                ubicacion = "Biblioteca",
                prioridad = "Baja"
            )
        }
    }
}
@Composable
fun PantallaReportes(modifier: Modifier = Modifier) {

    val reportes = listOf(
        Triple("Proyector dañado", "Aula 204", "Alta"),
        Triple("Luminaria sin funcionar", "Laboratorio 3", "Medios de comunicación"),
        Triple("Puerta atascada", "Biblioteca", "Baja"),
        Triple("Fuga de agua", "Baños, bloque B", "Urgente")
    )

    val totalReportes = reportes.size

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Reportes del instituto",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Total: $totalReportes reportes",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        reportes.forEach { (titulo, ubicacion, prioridad) ->
            TarjetaReporte(
                titulo = titulo,
                ubicacion = ubicacion,
                prioridad = prioridad
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}