package kz.aidar.dostap.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import coil3.compose.AsyncImage
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.arrow_right
import dostap.composeapp.generated.resources.user
import kz.aidar.dostap.presentation.models.EventCardData
import kz.aidar.dostap.presentation.screens.screens.event_tab.ExpandedEventScreen
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EventCard(event: EventCardData){
    val navigator = LocalNavigator.current
    Row(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(2.336f)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.White)
        .clickable {
            navigator?.push(ExpandedEventScreen(event, navigator))
        }
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(.572f).fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
            Column() {
                Row {
                    Text(text = event.date, color = MaterialTheme.colors.onSecondary, fontSize = 14.sp)
                    Spacer(Modifier.size(5.dp))
                    Text(text = event.time, color = MaterialTheme.colors.onSecondary, fontSize = 14.sp)
                }
                Text(text = event.location, color = MaterialTheme.colors.onSecondary, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)

            }
            Text(text = event.title, fontSize = 16.sp, maxLines = 2, color = Color.Black, overflow = TextOverflow.Ellipsis)
        }
        Box(modifier = Modifier.weight(.428f).fillMaxHeight()) {
            Box(modifier = Modifier.fillMaxSize().aspectRatio(1f).padding(16.dp).clip(
                RoundedCornerShape(16.dp)
            )){
                AsyncImage(model = event.image, contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            }

            ParticipantsCountIndicator(event.participantsCount, event.participantsTotal)
        }
    }
}
@Composable
fun InfoCard(icon: DrawableResource, text: String){
    Row(modifier = Modifier
        .clip(RoundedCornerShape(12.dp))
        .background(Color(0xFFF7F7F7))
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painterResource(icon), contentDescription = "", tint = MaterialTheme.colors.primary)
        Spacer(Modifier.size(6.dp))
        Text(text)
    }
}

@Composable
fun BoxScope.ParticipantsCountIndicator(count: Int, total:Int){
    Row(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .clip(RoundedCornerShape(34.dp))
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = 12.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(modifier = Modifier.size(14.dp), painter = painterResource(Res.drawable.user), contentDescription = "", tint = Color.White)
        Spacer(Modifier.size(4.dp))
        Text(text = "$count/$total", color = Color.White, fontSize = 13.sp)
    }
}
@OptIn(InternalResourceApi::class)
@Composable
fun PrimaryButton(
    onClick: ()->Unit,
    leadingIcon:  DrawableResource? = null, trailingIcon: DrawableResource? = null, text: StringResource, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(0.dp)
    ){
        if (leadingIcon != null) {
            Icon(painter = painterResource(leadingIcon), contentDescription = "", tint = Color.White, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.size(10.dp))
        }
        Text(text = stringResource(text), fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        if (trailingIcon != null) {
            Spacer(modifier = Modifier.size(10.dp))
            Icon(painter = painterResource(trailingIcon), contentDescription = "", tint = Color.White, modifier = Modifier.size(24.dp))
        }
    }
}
@Composable
fun SecondaryButton(onClick: ()->Unit,leadingIcon:  DrawableResource? = null, trailingIcon: DrawableResource? = null, text: StringResource, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(0.dp)
    ){
        if (leadingIcon != null) {
            Icon(painterResource(leadingIcon), contentDescription = "", tint = MaterialTheme.colors.primary, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.size(10.dp))
        }
        Text(text = stringResource(text), fontWeight = FontWeight.SemiBold, fontSize = 16.sp,color = MaterialTheme.colors.primary)
        if (trailingIcon != null) {
            Icon(painterResource(trailingIcon), contentDescription = "", tint = MaterialTheme.colors.primary, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}
@Composable
fun PrimaryTextInput(
    value:String,
    modifier: Modifier = Modifier,
    onValueChanged: (String)->Unit,
    trailingIcon: DrawableResource? = null,
    leadingIcon: DrawableResource? = null,
    label:StringResource,
    onTrailingIconClicked: ()->Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default){
    TextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier,
        trailingIcon = {
            if (trailingIcon != null) {Icon(painterResource(trailingIcon), contentDescription = "", tint = MaterialTheme.colors.secondaryVariant, modifier = Modifier.clickable { onTrailingIconClicked() })}},
        leadingIcon = { if (leadingIcon != null) {Icon(painterResource(leadingIcon), contentDescription = "", tint = MaterialTheme.colors.primaryVariant)}},
        shape = RoundedCornerShape(16.dp),
        label = {Text(stringResource(label), color = MaterialTheme.colors.primaryVariant)},
        placeholder = { Text(stringResource(label), color = MaterialTheme.colors.primaryVariant) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.onPrimary,
            textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colors.primaryVariant,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}
@Composable
fun LabelText(text:StringResource, color: Color = Color.Black){
    Text(stringResource(text), color = color, fontWeight = FontWeight.Bold, fontSize = 32.sp)
}
@Composable
fun RegistrationScreenTemplate(topPart: @Composable ()->Unit, bottomPart: @Composable ()->Unit){
    Column(modifier = Modifier.fillMaxSize().padding(20.dp).padding(top = 40.dp, bottom = 20.dp), verticalArrangement = Arrangement.SpaceBetween){
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start){topPart()}
        Column(modifier = Modifier.fillMaxWidth()){bottomPart()}
    }
}