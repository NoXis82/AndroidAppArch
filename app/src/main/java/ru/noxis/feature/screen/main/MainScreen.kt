package ru.noxis.feature.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import ru.noxis.androidapparch.ui.theme.AndroidAppArchTheme
import ru.noxis.common.navigation.api.composableTo
import ru.noxis.feature.screen.main.navigation.MainDirection
import ru.noxis.feature.screen.main.navigation.MainRouter

fun NavGraphBuilder.composableToMain() = composableTo(MainDirection) { MainScreen() }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "MainScreen2")
            })
        },
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(8.dp)
            ) {
                Button(viewModel::toTransactions) {
                    Text(text = "Транзакции")
                }
            }
        }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Button(
                onClick = { /*TODO*/ }, shape = CircleShape, modifier = Modifier
                    .padding(60.dp)
                    .size(160.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Баланс")
                    Text(text = "300р")
                }
            }
            Row {
                Button(viewModel::addDebit) {
                    Text(text = "< Дебет")
                }
                Spacer(modifier = Modifier.size(60.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Кредит >")
                }
            }

        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AndroidAppArchTheme(darkTheme = false) {
        MainScreen(MainViewModel(object : MainRouter {
            override fun toTransactions() {
                TODO("Not yet implemented")
            }

            override fun toCreateDebit() {
                TODO("Not yet implemented")
            }
        }))
    }
}