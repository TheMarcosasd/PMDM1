package com.dam2.appleton1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dam2.appleton1.ui.theme.Appleton1Theme

class MainActivity : ComponentActivity() {
    val TAG : String = "Estado" //val=value -> es una constante :)
    //var numero : Int = 3 -> es lo mismo que val, excepto que no es constante -> las variables empiezan todas en mayúsculas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //entorno gráfico -> necesario siempre en el onCreate
        setContent { //recibe una función como parámetros
            Appleton1Theme { //lo mismo que antes
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Yellow) { //lo mismo
                    Saludo("NOMBRE")
                }
            }
            //mensaje de estado (solo lo puedo mirar el Logcat de la terminal de android)
            Log.d(TAG,"Estoy en onCreate")
            calcular(a=3,b=5,fun(n1:Int,n2:Int){
                val suma = n1 + n2
                Log.d("calcular",suma.toString())
            })
        }
        calcular (4, 1, fun(x,y){
            val resta = x - y
            Log.d("calcular",resta.toString())
        })


    }
    fun calcular(a:Int=0,b:Int=0,operacion: (x:Int,y:Int)->Unit){
        //val operation a+b
        operacion(a,b)
        Log.d("calcular",operacion.toString())
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"He llegado al start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "He llegado al resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"He llegado al pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "He llegado al stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "He llegado al restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "He llegado al destroy")
    }


}
@Composable
fun Saludo(name: String, modifier: Modifier = Modifier) {
    Row {
        Text(
            text = "Hola mi $name!",
            modifier = modifier,
            fontSize = 25.sp,
            lineHeight = 90.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Hola mi $name!",
            modifier = modifier,
            fontSize = 50.sp,
            lineHeight = 100.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Appleton1Theme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Yellow) { //lo mismo
            Saludo("NOMBRE")
        }
    }
}