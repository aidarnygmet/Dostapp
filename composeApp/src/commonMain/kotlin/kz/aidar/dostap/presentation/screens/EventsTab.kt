package kz.aidar.dostap.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.aliya_event
import dostap.composeapp.generated.resources.arrow_right
import dostap.composeapp.generated.resources.background
import dostap.composeapp.generated.resources.events_tab_icon
import dostap.composeapp.generated.resources.fire
import dostap.composeapp.generated.resources.friends_tab_icon
import dostap.composeapp.generated.resources.my_events
import dostap.composeapp.generated.resources.puzzle
import dostap.composeapp.generated.resources.search
import dostap.composeapp.generated.resources.standup
import kz.aidar.dostap.presentation.auth_components.LabelText
import kz.aidar.dostap.presentation.auth_components.PrimaryTextInput
import kz.aidar.dostap.presentation.auth_components.SecondaryButton
import kz.aidar.dostap.presentation.main_screen_components.EventCard
import kz.aidar.dostap.presentation.models.EventCard
import org.jetbrains.compose.resources.DrawableResource
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