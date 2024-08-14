package kz.aidar.dostap.presentation.screens.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.age
import dostap.composeapp.generated.resources.arrow_right
import dostap.composeapp.generated.resources.clear
import dostap.composeapp.generated.resources.confirm
import dostap.composeapp.generated.resources.gender
import dostap.composeapp.generated.resources.name
import dostap.composeapp.generated.resources.tell_about_self
import dostap.composeapp.generated.resources.user
import dostap.composeapp.generated.resources.username
import kz.aidar.dostap.presentation.components.LabelText
import kz.aidar.dostap.presentation.components.PrimaryButton
import kz.aidar.dostap.presentation.components.PrimaryTextInput
import kz.aidar.dostap.presentation.components.RegistrationScreenTemplate

class AdditionalInfoScreen:Screen {

    @Composable
    override fun Content() {
        var name by remember {
            mutableStateOf("")
        }
        var username by remember {
            mutableStateOf("")
        }
        var gender by remember {
            mutableStateOf("")
        }
        var age by remember {
            mutableStateOf("")
        }
        val navigator = LocalNavigator.currentOrThrow
        RegistrationScreenTemplate(
            topPart = {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "", modifier = Modifier.clickable {
                    navigator.pop()
                })
                Spacer(Modifier.size(16.dp))
                LabelText(Res.string.tell_about_self)
                Spacer(Modifier.size(16.dp))
                PrimaryTextInput(value = name, onValueChanged = {Res.drawable.clear
                    name = it
                }, label = Res.string.name, trailingIcon = Res.drawable.clear, leadingIcon = Res.drawable.user, onTrailingIconClicked = {
                    name = ""
                }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.size(16.dp))
                PrimaryTextInput(value = username, onValueChanged = {
                    username = it
                }, label = Res.string.username, trailingIcon = Res.drawable.clear, leadingIcon = Res.drawable.user, onTrailingIconClicked = {
                    username = ""
                }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.size(16.dp))
                PrimaryTextInput(value = gender, onValueChanged = {
                    gender = it
                }, label = Res.string.gender, trailingIcon = Res.drawable.clear, leadingIcon = Res.drawable.gender, onTrailingIconClicked = {
                    gender = ""
                }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.size(16.dp))
                PrimaryTextInput(value = age, onValueChanged = {
                    age = it
                }, label = Res.string.age, trailingIcon = Res.drawable.clear, leadingIcon = Res.drawable.age, onTrailingIconClicked = {
                    age = ""
                }, modifier = Modifier.fillMaxWidth())
            }
        ){
            PrimaryButton(onClick = {
                navigator.push(AYFNUScreen())
            }, text = Res.string.confirm, trailingIcon = Res.drawable.arrow_right, modifier = Modifier.fillMaxWidth())
        }
    }
}