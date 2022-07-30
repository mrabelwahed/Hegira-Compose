package com.ramadan.composeplayground.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ramadan.composeplayground.R


val customFont = FontFamily(
     Font(R.font.amiri_bold, FontWeight.Bold)
 )
// Set of Material typography styles to start with
val Typography = Typography(
   defaultFontFamily = customFont
)