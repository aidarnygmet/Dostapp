package kz.aidar.dostap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(
//            android.graphics.Color.TRANSPARENT,
//            android.graphics.Color.TRANSPARENT
//        ))

        setContent {
            App()
        }
    }
}

