package kz.aidar.dostap.presentation.auth_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun PrimaryButton(
    onClick: ()->Unit,
    leadingIcon:  DrawableResource? = null, trailingIcon: DrawableResource? = null, text: String, modifier: Modifier = Modifier){
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
        Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        if (trailingIcon != null) {
            Spacer(modifier = Modifier.size(10.dp))
            Icon(painter = painterResource(trailingIcon), contentDescription = "", tint = Color.White, modifier = Modifier.size(24.dp))
        }
    }
}
@Composable
fun SecondaryButton(onClick: ()->Unit,leadingIcon:  DrawableResource? = null, trailingIcon: DrawableResource? = null, text: String, modifier: Modifier = Modifier){
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
        Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 16.sp,color = MaterialTheme.colors.primary)
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
    label:String,
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
        label = {Text(label, color = MaterialTheme.colors.primaryVariant)},
        placeholder = { Text(label, color = MaterialTheme.colors.primaryVariant) },
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
fun LabelText(text:String, color: Color = Color.Black){
    Text(text, color = color, fontWeight = FontWeight.Bold, fontSize = 32.sp)
}
@Composable
fun RegistrationScreenTemplate(topPart: @Composable ()->Unit, bottomPart: @Composable ()->Unit){
    Column(modifier = Modifier.fillMaxSize().padding(20.dp).padding(top = 40.dp, bottom = 20.dp), verticalArrangement = Arrangement.SpaceBetween){
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start){topPart()}
        Column(modifier = Modifier.fillMaxWidth()){bottomPart()}
    }
}