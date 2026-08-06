package com.coolkarni.aryaman.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coolkarni.aryaman.ui.auth.LoginScreen
import com.coolkarni.aryaman.ui.auth.RegisterScreen
import com.coolkarni.aryaman.ui.home.HomeScreen
import com.coolkarni.aryaman.ui.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.Splash.route,
        modifier = modifier
    ) {

        composable(AppDestination.Splash.route) {

            SplashScreen(
                onNavigateToLogin = {

                    navController.navigate(AppDestination.Login.route) {

                        popUpTo(AppDestination.Splash.route) {
                            inclusive = true
                        }

                    }
                }
            )
        }

        composable(AppDestination.Login.route) {
            LoginScreen()
        }

        composable(AppDestination.Register.route) {
            RegisterScreen()
        }

        composable(AppDestination.Home.route) {
            HomeScreen()
        }
    }
}