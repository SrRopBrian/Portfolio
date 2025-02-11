package com.example.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.portfolio.ui.theme.Black
import com.example.portfolio.ui.theme.DarkBlue
import com.example.portfolio.ui.theme.Orange
import com.example.portfolio.ui.theme.PortfolioTheme
import com.example.portfolio.ui.theme.Violet

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val scrollState = rememberScrollState()
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        GradientBackground(Modifier)
                        Column(
                            modifier = Modifier.verticalScroll(state = scrollState),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ProfileCard(Modifier)
                            UserHandles(Modifier)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun GradientBackground(modifier: Modifier) {
    val colorStops = arrayOf(
        0.0f to Orange,
        0.3f to DarkBlue,
        0.68f to Black,
        1f to Violet)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.linearGradient(
                colorStops = colorStops
            )
        )
        .zIndex(0f)
    )
}

@Composable
fun ProfileCard(modifier: Modifier) {
    val poppins = FontFamily(
        Font(R.font.poppins_semibold, FontWeight.SemiBold)
    )
    val inter = FontFamily(
        Font(R.font.inter_18pt_regular, FontWeight.Normal)
    )

    // Profile Picture Drawer
    Column(modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(36.dp))
        Card(modifier = Modifier
            .fillMaxWidth(0.35f)
            .zIndex(1f)
            .offset(y = 55.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rop),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center))
            }
        }

        // Bio
        Box(modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White.copy(alpha = 0.1f))
            .padding(18.dp)
            ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(46.dp))
                Text(text = "Rop Brian",
                    color = Color.White,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp)
                Text(text = "@menibryan",
                    color = Color.White.copy(alpha = 0.7f),
                    fontFamily = inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp)
                Spacer(modifier  = Modifier.height(16.dp))

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "🌅 10.05.2004",
                        color = Color.White,
                        fontFamily = inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp)
                    Text(text = "📱 Android Developer",
                        color = Color.White,
                        fontFamily = inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp)
                    Text(text = "🧑🏽‍💻 For the love of God | For the love of code",
                        color = Color.White,
                        fontFamily = inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp)
                }
                Spacer(modifier  = Modifier.height(20.dp))

                Row {
                    Icon(
                        Icons.Outlined.Place,
                        contentDescription = "Location",
                        tint = Color.White
                    )
                    Spacer(modifier  = Modifier.width(3.dp))
                    Text(text = "Nairobi, Kenya",
                        color = Color.White,
                        fontFamily = inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp)
                    Spacer(modifier  = Modifier.width(16.dp))
                    Icon(
                            painter = painterResource(id = R.drawable.birthday_cake),
                            contentDescription = "Birthday",
                            tint = Color.White,
                            modifier = Modifier.size(21.dp)
                    )
                    Spacer(modifier  = Modifier.width(7.dp))
                    Text(text = "Joined in 2024",
                        color = Color.White,
                        fontFamily = inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp)
                }
                Spacer(modifier  = Modifier.height(4.dp))

            }
        }
    }
}

// user social media handles and links
@Composable
fun UserHandles(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.email),
                    contentDescription = "email",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .weight(2f)
                        .height(90.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "facebook",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(1f)
                        .height(90.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.github),
                contentDescription = "GitHub",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
                    .height(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(2f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "LinkedIn",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(180.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.medium),
                        contentDescription = "Medium",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(12.dp))
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.twitter),
                        contentDescription = "Twitter",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(12.dp))
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.instagram),
                contentDescription = "Instagram",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
                    .height(100.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}
