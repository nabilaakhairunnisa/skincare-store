package com.nabila.skincarestore.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nabila.skincarestore.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.nabila.skincarestore.MainActivity.Companion.context
import com.nabila.skincarestore.ui.theme.MySkincareTheme

@Composable
fun ProfileScreen() {
    LazyColumn {

        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(30.dp))
                Image(
                    painter = painterResource(R.drawable.me),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.profile_name),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.role),
                    style = MaterialTheme.typography.titleMedium.copy(),
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        item {
            Column(Modifier.padding(15.dp)) {
                ButtonProfile(context.getString(R.string.link_email), context.getString(R.string.email), R.drawable.ic_email)
                ButtonProfile(context.getString(R.string.link_phone), context.getString(R.string.phone), R.drawable.ic_phone)
                ButtonProfile(context.getString(R.string.link_github), context.getString(R.string.github), R.drawable.github)
                ButtonProfile(context.getString(R.string.link_linkedIn), context.getString(R.string.linkedIn), R.drawable.linkedin)
                ButtonProfile(context.getString(R.string.link_instagram), context.getString(R.string.instagram), R.drawable.instagram)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun ProfileScreenPreview() {
    MySkincareTheme {
        ProfileScreen()
    }
}