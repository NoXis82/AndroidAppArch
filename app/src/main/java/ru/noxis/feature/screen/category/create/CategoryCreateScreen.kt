@file:OptIn(ExperimentalMaterial3Api::class)

package ru.noxis.feature.screen.category.create

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import kotlinx.coroutines.channels.consumeEach
import ru.noxis.common.enums.ReceiptType
import ru.noxis.common.navigation.api.composableTo
import ru.noxis.common.uikit.atom.chip.SwitchChip
import ru.noxis.common.uikit.molecule.category.CategoryItem
import ru.noxis.common.uikit.screen.emoji.ModalEmojiSelector
import ru.noxis.feature.screen.category.create.navigation.CategoryCreateDirection

fun NavGraphBuilder.composableToCategoryCreate() =
    composableTo(CategoryCreateDirection) { CategoryCreateScreen() }

@Composable
fun CategoryCreateScreen(viewModel: CategoryCreateViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Создание категории") }, navigationIcon = {
                IconButton(viewModel::close) {
                    Icon(Icons.Rounded.Close, contentDescription = "Close")
                }
            })
        }
    ) { padding ->

        val context = LocalContext.current
        LaunchedEffect(viewModel) {
            viewModel.error.consumeEach {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }

        val category: NewCategoryModel by viewModel.newCategory.collectAsState()

        var showIconSelector by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.size(100.dp)) {
                    CategoryItem(category.title, category.emoji) {
                        showIconSelector = true
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Text(text = "Название")
            Spacer(Modifier.height(4.dp))
            TextField(
                value = category.title,
                onValueChange = viewModel::changeTitle,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )
            Spacer(Modifier.height(12.dp))
            Text(text = "Типы")
            LazyRow(Modifier.fillMaxWidth()) {
                items(ReceiptType.entries.toTypedArray()) { type ->
                    SwitchChip(
                        type.name,
                        category.types.contains(type),
                        Modifier.padding(4.dp)
                    ) {
                        viewModel.changeType(type)
                    }
                }
            }
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(onClick = { viewModel.saveNewCategory() }) {
                    Text(text = "Сохранить")
                }
            }

            if (showIconSelector) {
                ModalEmojiSelector(
                    onSelectEmoji = { emoji ->
                        viewModel.changeEmoji(emoji)
                    },
                    onClose = {
                        showIconSelector = false
                    }
                )
            }
        }
    }
}