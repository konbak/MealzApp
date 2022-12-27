package com.android.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.mealzapp.model.response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?){

    var isExpanded by remember {
        mutableStateOf(false)
    }
    val imageSizeDp: Dp by animateDpAsState(targetValue = if (isExpanded) 200.dp else 100.dp)
    Column{
        Row{
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = 12.dp,
                    color = Color.Green
                )
            ) {
                AsyncImage(
                    model = meal?.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }
            Text(
                text = meal?.name?: "name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            modifier = Modifier
                .padding(16.dp),
            onClick = {
                isExpanded = !isExpanded
            }
        ){
            Text("change state of meal profile picture")
        }
    }
}
