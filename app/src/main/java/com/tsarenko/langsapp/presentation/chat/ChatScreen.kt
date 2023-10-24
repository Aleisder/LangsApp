package com.tsarenko.langsapp.presentation.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.tsarenko.langsapp.domain.model.DialogItem
import com.tsarenko.langsapp.util.HorizontalSpacer

@Composable
fun ChatScreen() {

    val dialog = DialogItem(
        name = "Ryan Gosling",
        avatar = "https://enoughproject.org/wp-content/uploads/2017/04/Ryan_Gosling-e1493121669188-300x300.jpg",
        lastMessage = "Hello, how are you doing?",
        isOnline = true
    )

    val dialogs = List(15) { dialog }

    LazyColumn() {
        items(dialogs) {
            DialogListItem(dialogItem = it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun DialogListItem(
    dialogItem: DialogItem
) {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row() {
            GlideImage(
                model = dialogItem.avatar,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            HorizontalSpacer(15)

            Column() {
                Text(text = dialogItem.name)
                Text(text = dialogItem.lastMessage)
            }
        }
    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}