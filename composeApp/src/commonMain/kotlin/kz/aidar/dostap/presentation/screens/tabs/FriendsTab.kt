package kz.aidar.dostap.presentation.screens.tabs

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.events_tab_icon
import dostap.composeapp.generated.resources.friends
import dostap.composeapp.generated.resources.friends_tab_icon
import org.jetbrains.compose.resources.painterResource

object FriendsTab: Tab {
    @Composable
    override fun Content() {
        Text("Friends")
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = "Friends",
            icon = painterResource(Res.drawable.friends_tab_icon)
        )
}