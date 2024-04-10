 package com.main.artspacermv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.artspacermv.ui.theme.ArtSpaceRMVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceRMVTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val fistArt = R.drawable.meme_random
    val secondArt = R.drawable.inmo_image
    val thirdArt = R.drawable.frieren_face

    var title by remember {
        mutableStateOf(R.string.meme)
    }

    var typeImage by remember {
        mutableStateOf(R.string.meme_year)
    }

    var currentArt by remember {
        mutableStateOf(fistArt)
    }

    var imageResource by remember {
        mutableStateOf(currentArt)
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(fontSize = 32.sp, fontWeight = FontWeight.Bold, text = "Art Space RMV")
        Spacer(modifier = Modifier.padding(8.dp))
        ImageArtwork(currentArtwork = currentArt)
        Spacer(modifier = modifier.padding(24.dp))
        TitleArtSpace(title = title, year = typeImage)
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Button(onClick = {
            /*FUNCION PARA IR AL ANTERIOR*/
                when (currentArt) {
                    fistArt -> {
                        currentArt = thirdArt
                        title = R.string.frieren_face
                        typeImage = R.string.frieren_year
                    }
                    secondArt -> {
                        currentArt = fistArt
                        title = R.string.meme
                        typeImage = R.string.meme_year
                    }
                    thirdArt -> {
                        currentArt = secondArt
                        title = R.string.inmo_image
                        typeImage = R.string.Inmo_year
                    }
                    else -> {
                        currentArt = secondArt
                        title = R.string.inmo_image
                        typeImage = R.string.Inmo_year
                    }
                }
            }) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Button(onClick = {
            /*FUNCIÓN PARA IR AL SIGUIENTE*/
                when (currentArt) {
                    fistArt -> {
                        currentArt = secondArt
                        title = R.string.inmo_image
                        typeImage = R.string.Inmo_year
                    }
                    secondArt -> {
                        currentArt = thirdArt
                        title = R.string.frieren_face
                        typeImage = R.string.frieren_year
                    }
                    thirdArt -> {
                        currentArt = fistArt
                        title = R.string.meme
                        typeImage = R.string.meme_year
                    }
                    else -> {
                        currentArt = fistArt
                        title = R.string.meme
                        typeImage = R.string.meme_year
                    }
                }
            }) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

 @Composable
fun ImageArtwork(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
     Card(
         elevation = CardDefaults.cardElevation(
             defaultElevation = 6.dp
         ),
         modifier = modifier
             .fillMaxWidth()
             .padding(8.dp)
             .size(width = 240.dp, height = 300.dp)

     ) {
         Image(
             painter = painterResource(currentArtwork),
             contentDescription = stringResource(id = R.string.meme),
             modifier = modifier.fillMaxWidth(),
             contentScale = ContentScale.FillBounds
         )
     }
}

@Composable
fun TitleArtSpace(
    @StringRes title: Int,
    @StringRes year: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            fontSize = 32.sp
        )

        Text(
            text = "Año de creación: ${stringResource(id = year)} ",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceRMVTheme {
        MainScreen()
    }
}