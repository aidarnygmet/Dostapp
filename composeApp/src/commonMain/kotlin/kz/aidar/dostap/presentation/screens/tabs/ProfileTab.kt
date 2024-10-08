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
import dostap.composeapp.generated.resources.profile
import dostap.composeapp.generated.resources.user
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.painterResource

object ProfileTab:Tab {

    @Composable
    override fun Content() {
        Text("Profile")
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 3u,
            title = "Profile",
            icon = painterResource(Res.drawable.user)
        )

}