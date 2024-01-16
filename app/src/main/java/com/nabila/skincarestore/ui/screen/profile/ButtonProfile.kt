package com.nabila.skincarestore.ui.screen.profile

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nabila.skincarestore.MainActivity.Companion.context
import com.nabila.skincarestore.R
import com.nabila.skincarestore.ui.theme.LightPink
import com.nabila.skincarestore.ui.theme.MySkincareTheme

@Composable
fun ButtonProfile(
    link: String,
    text: String,
    icon: Int,
) {
    val openLinkLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { }

    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors((LightPink), contentColor = Color.Black),
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            openLinkLauncher.launch(intent)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.width(30.dp)
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = text
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
@Preview(showBackground = true)
fun ButtonProfileItemPreview() {
    MySkincareTheme {
        ButtonProfile("",  context.getString(R.string.email), R.drawable.ic_email)
    }
}