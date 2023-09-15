package muk.dev.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface

import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import muk.dev.presentation.ui.theme.Happy_smilingTheme
import muk.dev.presentation.viewmodel.TempViewModel
import androidx.compose.material.MaterialTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : TempViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this,"tempValue = ${viewModel.getTempModel().name}",Toast.LENGTH_LONG).show()
        setContent {
            Happy_smilingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

