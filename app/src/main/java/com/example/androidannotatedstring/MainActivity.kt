package com.example.androidannotatedstring

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mContext = LocalContext.current
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    buildAnnotatedString {

                        val link =
                            LinkAnnotation.Clickable(
                                "",
                                TextLinkStyles(SpanStyle(color = Color.Blue,
                                    textDecoration = TextDecoration.Underline))
                            ) {
                                mContext.startActivity(Intent(mContext, SecondActivity::class.java))
                            }
                        withLink(link) { append("Urban") }
                        append(" University")
                    }, fontSize = 32.sp
                )
            }
        }
    }
}
