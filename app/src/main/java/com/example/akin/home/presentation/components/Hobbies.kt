package com.example.akin.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.akin.home.data.Hobby
import com.example.akin.home.data.HobbyIcon

@Composable
fun Hobbies(
 hobbies: List<Hobby>
) {
    Surface(
        modifier = Modifier
            .height(32.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFF44E267),
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (hobby in hobbies) {
                Icon(
                    imageVector = HobbyIcon.valueOf(hobby.name.uppercase()).icon,
                    contentDescription = "icon hobby",
                    tint = Color(0xFF1E1E1E)
                )
            }
        }
    }
}

public val hobbiesList = listOf(
    Hobby(id = 1, name = "video_games"),
    Hobby(id = 2, name = "tennis"),
    Hobby(id = 3, name = "soccer")
)

@Preview()
@Composable
fun HobbiesPreview(){
    Hobbies(hobbiesList);
}
