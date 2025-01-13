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
        enableEdgeToEdge()
        setContent {
            PresentationCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainContainer(
                        fullName = "Android",
                        shortDescription = "",
                        //modifier = Modifier.padding(innerPadding)
                    )
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
fun FeatureCard (cardDescription: String, icon: Painter,modifier: Modifier = Modifier) {
    Box (modifier
        .size(140.dp)
        .background(color = Color(0xFF1F4E4B), shape = RoundedCornerShape(16.dp))
        .padding(15.dp)
    ) {
        Column (verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()){
            Icon(painter = icon, contentDescription = "icon", tint = Color.White)
            Text(text = cardDescription, modifier = modifier, color = Color.White)
            Text(text = "Here we go two line", color = Color.White)
        }
    }
}

@Composable
fun FeatureCardsRow(modifier: Modifier = Modifier) {
    val state = rememberScrollState()
    Row(modifier.horizontalScroll(state)) {
        FeatureCard("lorem ipsum", painterResource(R.drawable.comment_24px))
        Spacer(modifier = Modifier.width(25.dp))
        FeatureCard("lorem ipsum", painterResource(R.drawable.forest_24px))
        Spacer(modifier = Modifier.width(25.dp))
        FeatureCard("lorem ipsum", painterResource(R.drawable.rocket_launch_24px))
        Spacer(modifier = Modifier.width(25.dp))
        FeatureCard("lorem ipsum", painterResource(R.drawable.category_24px))
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
fun MainContainer(fullName: String, shortDescription: String, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(color = Color(0xFF12140E))
    ) {
        CharacterIntroduction("Lorem Ipsum", modifier.padding(30.dp))
        CuriousInformation(
            "More about me",
            "I'm still trying to figure it out who am I",
            "Still studying and learning things related with Computer Science",
            painterResource(R.drawable.prescriptions_24px),
            painterResource(R.drawable.cognition_24px)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PresentationCardTheme {
        MainContainer(fullName = "Franco De Bernardi", shortDescription = "")
    }
}