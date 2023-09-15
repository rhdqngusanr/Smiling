
package muk.dev.presentation.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.android.material.bottomnavigation.BottomNavigationView
import muk.dev.presentation.ui.theme.Happy_smilingTheme


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Happy_smilingTheme {
        MainScreen()
    }
}




@Composable
fun MainScreen() {


    Scaffold(
        bottomBar = {
            BottomAppBar(){

            }
        }
    )
    { paddingValues ->
        Box(
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding(), top = paddingValues.calculateTopPadding())
        ) {
            // your UI
        }
    }
}



@Composable
fun MainNavigationScreen() {
}
