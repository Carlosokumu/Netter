package com.carlos.netter.ui.theme.designsystem.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.carlos.netter.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String, colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title, style = MaterialTheme.typography.headlineMedium) },
        actions = {
            IconButton(onClick = {}) {
                val paintImage: Painter = painterResource(id = R.drawable.us)
                Image(
                    painter = paintImage,
                    contentDescription = stringResource(id = R.string.flag),
                    contentScale = ContentScale.Crop,
                    modifier = modifier.size(30.dp)
                )
            }
        },
        colors = colors,
        modifier = modifier
    )
}