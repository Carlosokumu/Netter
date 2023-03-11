package com.carlos.netter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.carlos.netter.composables.CurrencyScreen
import com.carlos.netter.ui.theme.designsystem.component.TopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetterApp(mainActivityViewModel: MainActivityViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Scaffold(
            contentColor = MaterialTheme.colorScheme.onBackground,
            topBar = {
                TopAppBar(
                    title = "USD",
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer

                    )
                )

            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                CurrencyScreen(mainActivityViewModel = mainActivityViewModel)
            }

        }
    }
}