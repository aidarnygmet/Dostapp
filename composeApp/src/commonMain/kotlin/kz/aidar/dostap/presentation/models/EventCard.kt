package kz.aidar.dostap.presentation.models

import org.jetbrains.compose.resources.DrawableResource

data class EventCard(
    val title: String,
    val description: String,
    val date: String,
    val time: String,
    val location: String,
    val image: String,
    val participantsCount: Int,
    val participantsTotal: Int
) {
}