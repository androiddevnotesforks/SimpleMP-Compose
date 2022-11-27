package com.lighttigerxiv.simple.mp.compose.navigation.screens.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lighttigerxiv.simple.mp.compose.BuildConfig
import com.lighttigerxiv.simple.mp.compose.R
import com.lighttigerxiv.simple.mp.compose.SCREEN_PADDING
import com.lighttigerxiv.simple.mp.compose.composables.BasicToolbar
import com.lighttigerxiv.simple.mp.compose.composables.CustomText

@Composable
fun AboutScreen(
    onBackClick:() -> Unit,
){

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(SCREEN_PADDING)
    ) {

        BasicToolbar(
            backText = "Home",
            onBackClick = {onBackClick()}
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f, fill = true)
                .verticalScroll(rememberScrollState())
        ) {

            CustomText(
                text = "App Version",
                weight = FontWeight.Bold
            )

            CustomText(
                text = remember{BuildConfig.VERSION_NAME}
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomText(
                text = "App Source",
                weight = FontWeight.Bold
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse("https://github.com/lighttigerXIV/SimpleMP-Compose") }
                        context.startActivity(intent)
                    }
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    painter = painterResource(id = R.drawable.icon_github),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = true)
                ) {

                    CustomText(
                        text = "GitHub",
                        weight = FontWeight.Bold
                    )

                    CustomText(
                        text = "Get the project source on GitHub",
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    painter = painterResource(id = R.drawable.icon_gitlab),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = true)
                ) {

                    CustomText(
                        text = "GitLab",
                        weight = FontWeight.Bold
                    )

                    CustomText(
                        text = "Get the project source on GitLab",
                    )
                }
            }
        }
    }
}