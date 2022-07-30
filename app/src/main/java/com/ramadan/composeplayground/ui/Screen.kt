package com.ramadan.composeplayground.ui


const val ID_ARG = "id"
const val NAME_ARG = "name"
sealed class Screen (val route: String){
    object Home:Screen("home_screen")
    object Details:Screen("details_screen/{id}/{name}")
    {
        fun passIdAndName(id: Int , name:String) : String{
            return "details_screen/$id/$name"
        }
    }
}