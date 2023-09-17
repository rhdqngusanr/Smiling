package muk.dev.presentation.ui


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberScaffoldState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.google.android.material.bottomnavigation.BottomNavigationView
import muk.dev.presentation.R
import muk.dev.presentation.ui.theme.Happy_smilingTheme
import muk.dev.presentation.ui.theme.colorPrimaryDark
import muk.dev.presentation.viewmodel.MainViewModel


sealed class MainNavigationItem(var route: String,val icon : ImageVector, var name: String) {
    object Main : MainNavigationItem("Main", Icons.Filled.Home ,"Main")
    object Category : MainNavigationItem("Category",Icons.Filled.Star, "Category")
    object MyPage : MainNavigationItem("MyPage",Icons.Filled.AccountBox, "MyPage")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Happy_smilingTheme {
        MainScreen()
    }
}


@Composable
fun MainScreen() {

    val viewModel = hiltViewModel<MainViewModel>()
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    Scaffold(
        topBar={ Header(viewModel)},
        scaffoldState = scaffoldState,
        bottomBar = {
            MainBottomNavigationBar(navController = navController)
        }
    )
    { paddingValues ->
        Box(
            modifier = Modifier.padding(
                bottom = paddingValues.calculateBottomPadding(),
                top = paddingValues.calculateTopPadding()
            )
        ) {
            // your UI
        }
        MainNavigationScreen(navController = navController)
    }
}
@Composable
fun Header(viewModel: MainViewModel){
    TopAppBar(
        title = { Text(text = "싱글벙글")},
        actions = {
            IconButton(onClick = {
                viewModel.openSearchForm()
            }) {
                Icon(Icons.Filled.Search,"SearchIcon")

            }
        }
        )
}
@Composable
fun MainBottomNavigationBar(navController: NavHostController) {
    val bottomNavigationItems = listOf(
        MainNavigationItem.Main,
        MainNavigationItem.Category,
        MainNavigationItem.MyPage
    )
    BottomNavigation(
        backgroundColor = colorPrimaryDark,//Color(0xffff0000),
        contentColor = Color(0xff00ff00)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(selected = currentRoute == item.route, onClick = {
                navController.navigate(item.route){
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(it){
                            saveState=true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }


            }, icon = { Icon(item.icon ,item.route) })
        }
    }
}

@Composable
fun MainNavigationScreen(navController: NavHostController) {

    NavHost(navController = navController, startDestination = MainNavigationItem.Main.route){
        composable(MainNavigationItem.Main.route){
            Text(text = "hello main ")
        }
        composable(MainNavigationItem.Category.route){
            Text(text = "hello Category")
        }
        composable(MainNavigationItem.MyPage.route){
            Text(text = "hello MyPage ")
        }
    }
}
