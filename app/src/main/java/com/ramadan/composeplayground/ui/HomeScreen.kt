package com.ramadan.composeplayground.ui

import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*

@Composable
fun homeScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Screen.Details.passIdAndName(100, "reem"))
            },
        contentAlignment = Alignment.Center
    ) {
        Loader()
       CustomView2()
    }
}

@Composable
private fun Loader() {


    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(LottieCompositionSpec.Asset("celebrate.json"))

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    LottieAnimation(
        compositionResult.value,
        progress,
        modifier = Modifier.padding(all = 50.dp),
        contentScale = ContentScale.FillBounds
    )

}



@Composable
fun CustomView2(){
    Canvas(modifier = Modifier.fillMaxSize()){
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawCircle(
             center= Offset(canvasWidth/2 , canvasHeight/16),
             color = Color.Blue,
            )

        drawContext.canvas.nativeCanvas.apply {
            val textPadding = 50.dp.toPx()
            val arcHeight = 300.dp.toPx()
            val arcWidth = 300.dp.toPx()

            // Path for curved text
            val path = Path().apply {
                addArc(canvasWidth/4, textPadding, arcWidth, arcHeight, 180f, 180f)
            }
            drawTextOnPath("عام هجري سعيد" ,path ,10f,0f,
                Paint().apply {
                    textSize = 150f
                    color = android.graphics.Color.WHITE
                    textAlign = Paint.Align.CENTER
                } )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview(){
    CustomView2()
}