package kz.aidar.dostap.presentation.screens.screens.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.are_you_from
import dostap.composeapp.generated.resources.arrow_right
import dostap.composeapp.generated.resources.clear
import dostap.composeapp.generated.resources.has_an_account
import dostap.composeapp.generated.resources.id_number
import dostap.composeapp.generated.resources.nazarbayev_university
import dostap.composeapp.generated.resources.nu_id
import dostap.composeapp.generated.resources.proceed
import kz.aidar.dostap.presentation.components.LabelText
import kz.aidar.dostap.presentation.components.PrimaryButton
import kz.aidar.dostap.presentation.components.PrimaryTextInput
import kz.aidar.dostap.presentation.components.RegistrationScreenTemplate
import kz.aidar.dostap.presentation.components.SecondaryButton

class AYFNUScreen() : Screen{
    override val key: ScreenKey = uniqueScreenKey
    @Composable
    override fun Content() {
        var nuId by remember{
            mutableStateOf("")
        }
        val navigator = LocalNavigator.currentOrThrow

        RegistrationScreenTemplate(topPart = {
            LabelText(Res.string.are_you_from)
            LabelText(Res.string.nazarbayev_university, color = MaterialTheme.colors.primary)
            Spacer(Modifier.size(16.dp))
            PrimaryTextInput(
                modifier = Modifier.fillMaxWidth(),
                value = nuId, onValueChanged = {
                nuId = it
            }, label = Res.string.nu_id, leadingIcon = Res.drawable.id_number, trailingIcon = Res.drawable.clear, onTrailingIconClicked = {
                nuId = ""
            }, keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
        }) {
            PrimaryButton(onClick = {
                navigator.push(RegistrationScreen())
            }, text = Res.string.proceed, trailingIcon = Res.drawable.arrow_right, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.size(16.dp))
            SecondaryButton(onClick = {
                navigator.push(LoginScreen())
            }, text = Res.string.has_an_account, modifier = Modifier.fillMaxWidth())
        }
    }



}