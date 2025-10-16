package ru.noxis.androidapparch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.consumeEach
import ru.noxis.androidapparch.ui.theme.AndroidAppArchTheme
import ru.noxis.common.navigation.api.Navigator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            LaunchedEffect(navController) {
                navigator.navActions.consumeEach { navigatorDirection ->
                    when (val state = navigatorDirection) {
                        is Navigator.Direction.Forward -> {
                            navController.navigate(
                                state.action.destination,
                                state.action.navOptions
                            )
                        }

                        Navigator.Direction.Back -> {
                            navController.navigateUp()
                        }
                    }
                }
            }
            AndroidAppArchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    NavHost(
//                        navController = navController,
//                        startDestination = MainDirection.route,
//                        builder = NavGraphBuilder::composableAll
//                    )
                }
            }
        }
    }
}
