package com.example.presentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationcard.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PresentationCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainContainer(fullName = stringResource(R.string.franco_de_bernardi))
                }
            }
        }
    }
}

@Composable
fun CuriousInformation (mainTitle: String, firstDetail: String, secondDetail: String, firstIcon: Painter, secondIcon: Painter, modifier: Modifier = Modifier) {
    Column (modifier = Modifier.padding(30.dp)) {
        Text(text = mainTitle, color = Color.White, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(15.dp))
        Row (modifier = Modifier) {
            Icon(painter = firstIcon, contentDescription = "icon", tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = firstDetail, color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier) {
            Icon(painter = secondIcon, contentDescription = "icon", tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = secondDetail, color = Color.White)
        }
    }
}

@Composable
fun FeatureCard (cardDescription: String, cardText: String, icon: Painter,modifier: Modifier = Modifier) {
    Box (modifier
        .size(150.dp)
        .background(color = Color(0xFF1F4E4B), shape = RoundedCornerShape(16.dp))
        .padding(15.dp)
    ) {
        Column (verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()){
            Icon(painter = icon, contentDescription = "icon", tint = Color.White)
            Text(text = cardDescription, modifier = modifier, color = Color.White)
            Text(text = cardText, color = Color.White)
        }
    }
}

@Composable
fun FeatureCardsRow(modifier: Modifier = Modifier) {
    val state = rememberScrollState()
    Row(modifier.horizontalScroll(state)) {
        FeatureCard(stringResource(R.string.favourite_book), stringResource(R.string.red_storm_by_tom_clancy), painterResource(R.drawable.comment_24px))
        Spacer(modifier = Modifier.width(25.dp))
        FeatureCard(stringResource(R.string.best_place), stringResource(R.string.bariloche_argentina), painterResource(R.drawable.forest_24px))
        Spacer(modifier = Modifier.width(25.dp))
        FeatureCard(stringResource(R.string.coolest_thing), stringResource(R.string.x_43a_nasa_s_scramjet), painterResource(R.drawable.rocket_launch_24px))
        Spacer(modifier = Modifier.width(25.dp))
        FeatureCard(stringResource(R.string.music), stringResource(R.string.mostly_indie),painterResource(R.drawable.category_24px))
    }
}

@Composable
fun CharacterIntroduction(fullName: String, modifier: Modifier = Modifier) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = fullName,
            color = Color(0xFFB1D18A),
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            lineHeight = 60.sp,
            modifier = modifier
        )
        Image(
            painter = painterResource(R.drawable.swordsman),
            contentDescription = "Person avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(210.dp)
                .clip(RoundedCornerShape(80.dp))
        )
        Spacer(modifier = Modifier.height(30.dp))
        FeatureCardsRow()
    }
}

@Composable
fun MainContainer(fullName: String, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(color = Color(0xFF12140E))
    ) {
        CharacterIntroduction(fullName, modifier.padding(30.dp))
        CuriousInformation(
            stringResource(R.string.more_about_me),
            stringResource(R.string.i_m_still_trying_to_figure_it_out_who_am_i),
            stringResource(R.string.still_studying_and_learning_things_related_with_computer_science),
            painterResource(R.drawable.prescriptions_24px),
            painterResource(R.drawable.cognition_24px)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PresentationCardTheme {
        MainContainer(fullName = stringResource(R.string.franco_de_bernardi))
    }
}