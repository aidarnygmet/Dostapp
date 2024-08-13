package kz.aidar.dostap.presentation.screens.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.events_tab_icon
import kz.aidar.dostap.presentation.screens.screens.EventMainScreen
import org.jetbrains.compose.resources.painterResource

object EventsTab : Tab {

    @Composable
    override fun Content() {
        Navigator(EventMainScreen(), onBackPressed = {
            true
        }){
            SlideTransition(it)
        }

    }
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 0u,
            title = "Events",
            icon = painterResource(Res.drawable.events_tab_icon)
        )
}