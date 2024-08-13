package kz.aidar.dostap.presentation.screens

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.chats_tab_icon
import dostap.composeapp.generated.resources.events_tab_icon
import org.jetbrains.compose.resources.painterResource

object ChatsTab:Tab {
    @Composable
    override fun Content() {
        Text("Chats")
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2u,
            title = "Chats",
            icon = painterResource(Res.drawable.chats_tab_icon)
        )
}