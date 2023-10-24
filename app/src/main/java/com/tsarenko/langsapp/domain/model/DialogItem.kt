package com.tsarenko.langsapp.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class DialogItem(
    val name: String,
    val avatar: String,
    val lastMessage: String,
    val isOnline: Boolean
)
