package kz.aidar.dostap.presentation.screens.bottom_sheets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.add_to_calendar
import dostap.composeapp.generated.resources.calendar
import dostap.composeapp.generated.resources.chats_tab_icon
import dostap.composeapp.generated.resources.go_to_chat
import dostap.composeapp.generated.resources.joined_event_1
import dostap.composeapp.generated.resources.right_arrow_head
import dostap.composeapp.generated.resources.share_event
import dostap.composeapp.generated.resources.upload_button
import kz.aidar.dostap.presentation.components.PrimaryButton
import kz.aidar.dostap.presentation.models.EventCardData
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class JoinEventBottomSheet(eventCard: EventCardData):Screen {
    val localEvent = eventCard
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxWidth().padding(25.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = stringResource(Res.string.joined_event_1), fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(Modifier.size(10.dp))
            Text(text = stringResource(Res.string.joined_event_1), fontSize = 16.sp)
            Spacer(Modifier.size(10.dp))
            AddToCalendar()
            Spacer(Modifier.size(10.dp))
            ShareEvent()
            Spacer(Modifier.size(10.dp))
            PrimaryButton(onClick = {}, leadingIcon = Res.drawable.chats_tab_icon, text = Res.string.go_to_chat, modifier = Modifier.fillMaxWidth())
        }
    }
    @Composable
    fun AddToCalendar(){
        Row(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colors.onPrimary).padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(Res.drawable.calendar), contentDescription = "", tint = MaterialTheme.colors.primary)
                Spacer(Modifier.size(6.dp))
                Text(text = stringResource(Res.string.add_to_calendar))
            }
            Icon(painterResource(Res.drawable.right_arrow_head), contentDescription = "", tint = MaterialTheme.colors.primary)

        }
    }
    @Composable
    fun ShareEvent(){
        Row(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colors.onPrimary).padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween)  {
            Row {
                Icon(painterResource(Res.drawable.upload_button), contentDescription = "", tint = MaterialTheme.colors.primary)
                Spacer(Modifier.size(6.dp))
                Text(text = stringResource(Res.string.share_event))
            }
            Icon(painterResource(Res.drawable.right_arrow_head), contentDescription = "", tint = MaterialTheme.colors.primary)

        }
    }
}