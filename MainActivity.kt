package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleCard(
                        header = stringResource(id = R.string.title),
                        into = stringResource(id = R.string.intro),
                        body = stringResource(id = R.string.body)
                    )
                }
            }
        }
    }
}

@Composable
private fun ArticleCard(header: String, into: String, body: String, modifier: Modifier = Modifier) {
    val imagePainter = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = imagePainter,
            contentDescription = null,
            alpha = 0.5F
        )
        Text(
            text = header,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = into,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        ArticleCard(
            header = "default header",
            into = "default intro",
            body = "default body",
        )
    }
}