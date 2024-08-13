package kz.aidar.dostap.presentation.screens.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import kz.aidar.dostap.presentation.screens.tabs.ChatsTab
import kz.aidar.dostap.presentation.screens.tabs.EventsTab
import kz.aidar.dostap.presentation.screens.tabs.FriendsTab
import kz.aidar.dostap.presentation.screens.tabs.ProfileTab


class MainScreen: Screen {
    @Composable
    override fun Content() {
        TabNavigator(EventsTab){
            Scaffold(
                bottomBar = {
                    BottomNavigation(
                    backgroundColor = Color.White,
                        elevation = 0.dp,
                    modifier = Modifier.fillMaxWidth()
                    ){
                        TabNavigationItem(EventsTab)
                        TabNavigationItem(FriendsTab)
                        TabNavigationItem(ChatsTab)
                        TabNavigationItem(ProfileTab)
                    }
                }
            ) {
                CurrentTab()
            }
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        BottomNavigationItem(
            selectedContentColor = MaterialTheme.colors.primary,
            unselectedContentColor = MaterialTheme.colors.primaryVariant,
            selected = tabNavigator.current == tab,
            onClick = { tabNavigator.current = tab },
            label = { Text(tab.options.title, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 14.sp) },
            icon = { tab.options.icon?.let { Icon(painter = it, contentDescription = "", modifier = Modifier.size(30.dp)) } }
        )
    }
}