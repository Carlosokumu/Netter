package com.carlos.netter.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.carlos.netter.R


@Composable
fun LoadFailedEmptyScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.load_fail), Modifier.align(Alignment.Center))
    }

}