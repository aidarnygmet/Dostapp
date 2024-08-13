package kz.aidar.dostap.presentation.screens.screens.event_tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import coil3.compose.AsyncImage
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.back_button
import dostap.composeapp.generated.resources.calendar
import dostap.composeapp.generated.resources.location
import dostap.composeapp.generated.resources.plus
import dostap.composeapp.generated.resources.shield_button
import dostap.composeapp.generated.resources.time
import dostap.composeapp.generated.resources.upload_button
import dostap.composeapp.generated.resources.user
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format.char
import kz.aidar.dostap.presentation.components.InfoCard
import kz.aidar.dostap.presentation.components.PrimaryButton
import kz.aidar.dostap.presentation.components.SecondaryButton
import kz.aidar.dostap.presentation.models.EventCardData
import kz.aidar.dostap.presentation.screens.bottom_sheets.JoinEventBottomSheet
import org.jetbrains.compose.resources.painterResource

class ExpandedEventScreen(eventCard: EventCardData, primaryNavigator: Navigator): Screen {
    private val localEvent = eventCard.copy()
    private val navigator = primaryNavigator
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    override fun Content() {
        BottomSheetNavigator(modifier = Modifier.padding(bottom = 56.dp), sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
            Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                EventImageBox()
                EventBody()
            }
        }

    }
    @Composable
    fun EventImageBox(){
        Box(modifier = Modifier.fillMaxWidth().aspectRatio(1.1f)){
            AsyncImage(modifier = Modifier.fillMaxSize(), model = localEvent.image, contentDescription = null, contentScale = ContentScale.Crop)
            Box(modifier = Modifier.fillMaxSize().padding(top = 35.dp, bottom = 10.dp).padding(horizontal = 15.dp)){
                Row(modifier = Modifier.fillMaxWidth().align(Alignment.TopStart), horizontalArrangement = Arrangement.SpaceBetween) {
                    Icon(modifier = Modifier.clickable {
                        navigator.pop()
                    },painter = painterResource(Res.drawable.back_button), contentDescription = null, tint = MaterialTheme.colors.secondary)
                    Row {
                        Icon(painter = painterResource(Res.drawable.upload_button), contentDescription = null, tint = MaterialTheme.colors.secondary)
                        Spacer(modifier = Modifier.size(12.dp))
                        Icon(painter = painterResource(Res.drawable.shield_button), contentDescription = null, tint = MaterialTheme.colors.secondary)
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().align(Alignment.BottomStart)){
                    Row {
                        InfoCard(Res.drawable.user, eventParticipantsString(localEvent.participantsCount, localEvent.participantsTotal))
                        Spacer(Modifier.size(8.dp))
                        InfoCard(Res.drawable.location, localEvent.location)
                    }
                    Spacer(Modifier.size(8.dp))
                    Row {
                        InfoCard(Res.drawable.calendar, formatDate(localEvent.date))
                        Spacer(Modifier.size(8.dp))
                        InfoCard(Res.drawable.time, localEvent.time)
                    }
                }
            }
        }
    }
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun EventBody(){
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        var textExpanded by remember {
            mutableStateOf(false)
        }
        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Read All")
            }
        }
        Column(modifier = Modifier.fillMaxWidth().padding(25.dp)) {
            Text(localEvent.title, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 32.sp, lineHeight = 36.sp)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = localEvent.description, maxLines = if(textExpanded){Int.MAX_VALUE}else{3}, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.size(7.dp))
            ClickableText(text = annotatedText, onClick = {
                textExpanded=!textExpanded
            })
            Spacer(modifier = Modifier.size(10.dp))
            Participants()
            Spacer(modifier = Modifier.size(10.dp))
            BottomSheetNavigator {
                PrimaryButton(onClick = {
                    bottomSheetNavigator.show(JoinEventBottomSheet(localEvent))
                }, leadingIcon = Res.drawable.plus, text = "Join the event", modifier = Modifier.fillMaxWidth())
            }

        }
    }
    @Composable
    private fun Participants(){
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            Text(text = "${localEvent.participantsCount} guys are coming", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(Modifier.size(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (localEvent.participantsCount>3){
                        for (x in 1..3){
                            Box(modifier = Modifier.clip(CircleShape).background(MaterialTheme.colors.secondary).padding(5.dp)){
                                Icon(painter = painterResource(Res.drawable.user), contentDescription = null, tint = MaterialTheme.colors.primary)
                            }
                            Spacer(modifier = Modifier.size(10.dp))
                        }
                        Box(modifier = Modifier.clip(CircleShape).background(MaterialTheme.colors.secondary).padding(5.dp)){
                            Icon(painter = painterResource(Res.drawable.plus), contentDescription = null, tint = MaterialTheme.colors.primary)
                        }
                    } else {
                        for (x in 1..localEvent.participantsCount){
                            Box(modifier = Modifier.clip(CircleShape).background(MaterialTheme.colors.secondary).padding(5.dp)){
                                Icon(painter = painterResource(Res.drawable.user), contentDescription = null, tint = MaterialTheme.colors.primary)
                            }
                            Spacer(modifier = Modifier.size(10.dp))
                        }
                    }
                }
                if (localEvent.participantsCount>3){
                    SecondaryButton(onClick = {}, text = "See all", modifier = Modifier)
                }
            }
        }

    }
    private fun eventParticipantsString(participants: Int, total: Int): String{
        return "$participants of $total"
    }
    private fun formatDate(inputDate: String): String {
        val formatter = LocalDate.Format {
            year()
            char('.')
            dayOfMonth()
            char('.')
            monthNumber()
        }
        val date = LocalDate.parse("2024.$inputDate", formatter)
        val daySuffix = when (date.dayOfMonth) {
            1, 21, 31 -> "st"
            2, 22 -> "nd"
            3, 23 -> "rd"
            else -> "th"
        }
        val month = date.month.name.lowercase().replaceFirstChar { it.uppercase() }
        return "$month, ${date.dayOfMonth}$daySuffix"
    }
}