package com.ramadan.composeplayground.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun setupNavGraph( navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            homeScreen(navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument(ID_ARG){
                    type = NavType.IntType
                },
                navArgument(NAME_ARG){
                    type = NavType.StringType
                }
        )
        ){
            Log.d("ARG","test" + it?.arguments?.getInt(ID_ARG)+ " "+it?.arguments?.getString(
                NAME_ARG))
            detailsScreen()
        }
    }
}