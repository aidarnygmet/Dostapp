package kz.aidar.dostap.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.aliya_event
import dostap.composeapp.generated.resources.arrow_right
import dostap.composeapp.generated.resources.background
import dostap.composeapp.generated.resources.fire
import dostap.composeapp.generated.resources.my_events
import dostap.composeapp.generated.resources.puzzle
import dostap.composeapp.generated.resources.search
import dostap.composeapp.generated.resources.standup
import kz.aidar.dostap.presentation.main_screen_components.EventCard
import kz.aidar.dostap.presentation.main_screen_components.SeeAll
import kz.aidar.dostap.presentation.models.EventCard
import org.jetbrains.compose.resources.painterResource

class EventMainScreen:Screen {
    val event1 = EventCard(
        title = "Aliya Aliyeva's Art exhibition",
        location = "Korme Exhibition Center",
        time = "19:00",
        participantsCount = 1,
        participantsTotal = 8,
        date = "25.07",
        description = "Discover the captivating world of Aliya Aliyeva, a celebrated Kazakh artist whose work transcends traditional boundaries. Aliya Aliyeva's art exhibition presents a unique blend of contemporary and classic influences, showcasing her mastery in capturing the essence of Kazakh culture and the human experience. " +
                "Through a diverse collection of paintings, sculptures, and mixed media, Aliyeva explores themes of identity, heritage, and modernity. Her vibrant use of color and innovative techniques invite viewers into a realm where tradition meets the avant-garde. " +
                "Each piece in the exhibition tells a story, reflecting Aliyeva's deep connection to her roots and her vision for the future. Whether you are an art enthusiast or a casual observer, this exhibition promises to be an inspiring journey through the mind and heart of one of Kazakhstan's most talented artists. " +
                "Join us for an unforgettable experience as we celebrate the artistic brilliance of Aliya Aliyeva.",
        image = "https://plus.unsplash.com/premium_photo-1722169882213-4aac70efe459?q=80&w=3387&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    )
    val event2 = EventCard(
        title = "Stand-up by Nurlan Saburov",
        location = "Bar Nazvaniye, Astana",
        time = "20:30",
        participantsCount = 12,
        participantsTotal = 15,
        date = "25.07",
        description = "",
        image = "https://plus.unsplash.com/premium_photo-1722169882213-4aac70efe459?q=80&w=3387&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    )
    val event3 = EventCard(
        title = "The Intellectual Quiz",
        location = "Jepara, Central Java",
        time = "17:00",
        participantsCount = 1,
        participantsTotal = 8,
        date = "03.08",
        description = "",
        image = "https://plus.unsplash.com/premium_photo-1722169882213-4aac70efe459?q=80&w=3387&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    )
    private val brush = Brush.verticalGradient(
        colors = listOf(
            Color(0x669A56FF),
            Color(0x009A56FF)
        )
    )
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF7F7F7)).padding(bottom = 56.dp).verticalScroll(
            rememberScrollState()
        )){
            Image(painter = painterResource(Res.drawable.background), "",modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp, vertical = 10.dp), contentScale = ContentScale.Crop)
            //Icon(painter = painterResource(Res.drawable.background), "", modifier = Modifier.fillMaxSize(), tint = Color(0xFFF0E5FF))
            Column(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(.2f).background(brush).padding(horizontal = 20.dp).padding(top = 60.dp), contentAlignment = Alignment.BottomCenter){
                    SearchInput(value = "", onValueChanged = {}, modifier = Modifier.fillMaxWidth())
                }
                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color(0x009A56FF))){
                    Column(modifier = Modifier.fillMaxSize().background(Color.Transparent).padding(horizontal = 20.dp, vertical = 40.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                            Icon(painter = painterResource(Res.drawable.fire), "", modifier = Modifier.size(24.dp))
                            Spacer(modifier = Modifier.size(10.dp))
                            EventsScrenLabelText("Interesting Now")
                        }
                        Spacer(modifier = Modifier.size(16.dp))
                        EventCard(event1)
                        Spacer(modifier = Modifier.size(10.dp))
                        EventCard(event2)
                        Spacer(modifier = Modifier.size(10.dp))
                        EventCard(event3)
                        Spacer(modifier = Modifier.size(10.dp))
                        SeeAll(onClick = {})
                        Spacer(modifier = Modifier.size(10.dp))
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                            Icon(painter = painterResource(Res.drawable.my_events), "", modifier = Modifier.size(24.dp))
                            Spacer(modifier = Modifier.size(10.dp))
                            EventsScrenLabelText("My events")
                        }
                    }
                }
            }

        }
    }
    @Composable
    fun EventsScrenLabelText(text:String, color: Color = Color.Black){
        Text(text, color = color, fontWeight = FontWeight.Bold, fontSize = 27.sp)
    }
    @Composable
    fun SearchInput(
        value:String,
        modifier: Modifier = Modifier,
        onValueChanged: (String)->Unit){
        TextField(
            value = value,
            onValueChange = onValueChanged,
            modifier = modifier,leadingIcon = { Icon(painterResource(Res.drawable.search), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) },
            shape = RoundedCornerShape(16.dp),
            label = { Text("Search", color = Color(0xFFB1B1B1)) },
            placeholder = { Text("Search", color = Color(0xFFB1B1B1)) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFFB1B1B1),
                unfocusedIndicatorColor = Color.Transparent
            ),
        )
    }

}