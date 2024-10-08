package kz.aidar.dostap.presentation.screens.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.arrow_right
import dostap.composeapp.generated.resources.clear
import dostap.composeapp.generated.resources.confirm_password
import dostap.composeapp.generated.resources.create_account
import dostap.composeapp.generated.resources.create_account_button
import dostap.composeapp.generated.resources.email
import dostap.composeapp.generated.resources.password
import dostap.composeapp.generated.resources.password_visible
import dostap.composeapp.generated.resources.terms_and_conditions
import kz.aidar.dostap.presentation.components.LabelText
import kz.aidar.dostap.presentation.components.PrimaryButton
import kz.aidar.dostap.presentation.components.PrimaryTextInput
import kz.aidar.dostap.presentation.components.RegistrationScreenTemplate
import kz.aidar.dostap.presentation.screens.screens.auth.AdditionalInfoScreen
import org.jetbrains.compose.resources.stringResource

class RegistrationScreen: Screen {
    @Composable
    override fun Content() {
        var email by remember{
            mutableStateOf("")
        }
        var password by remember{
            mutableStateOf("")
        }
        var confirmPassword by remember{
            mutableStateOf("")
        }
        var passwordVisibility by remember {
            mutableStateOf(false)
        }
        var passwordVisualTransformation: VisualTransformation by remember {
            mutableStateOf(PasswordVisualTransformation())
        }
        var passwordTrailingIcon by remember {
            mutableStateOf(Icons.Default.FavoriteBorder)
        }
        var confirmVisibility by remember {
            mutableStateOf(false)
        }
        var confirmVisualTransformation: VisualTransformation by remember {
            mutableStateOf(PasswordVisualTransformation())
        }
        var confirmTrailingIcon by remember {
            mutableStateOf(Icons.Default.FavoriteBorder)
        }
        var checked by remember {
            mutableStateOf(false)
        }
        val navigator = LocalNavigator.currentOrThrow
        RegistrationScreenTemplate(topPart = {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "", modifier = Modifier.clickable {
                navigator.pop()
            })
            Spacer(Modifier.size(16.dp))
            LabelText(text = Res.string.create_account)
            Spacer(Modifier.size(16.dp))
            PrimaryTextInput(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChanged = {
                    email = it
                }, label = Res.string.email, leadingIcon = Res.drawable.email, trailingIcon = Res.drawable.clear, onTrailingIconClicked = {
                    email = ""
                })
            Spacer(Modifier.size(16.dp))
            PrimaryTextInput(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChanged = {
                    password = it
                }, label = Res.string.password, leadingIcon = Res.drawable.password, trailingIcon = Res.drawable.password_visible,
                onTrailingIconClicked = {
                    passwordVisibility = !passwordVisibility
                    if(passwordVisibility){
                        passwordVisualTransformation = VisualTransformation.None
                        passwordTrailingIcon = Icons.Default.Favorite
                    } else {
                        passwordVisualTransformation = PasswordVisualTransformation()
                        passwordTrailingIcon = Icons.Default.FavoriteBorder
                    }
                },
                visualTransformation = passwordVisualTransformation)
            Spacer(Modifier.size(16.dp))
            PrimaryTextInput(
                modifier = Modifier.fillMaxWidth(),
                value = confirmPassword,
                onValueChanged = {
                    confirmPassword = it
                }, label = Res.string.confirm_password, leadingIcon = Res.drawable.password, trailingIcon = Res.drawable.password_visible,
                onTrailingIconClicked = {
                    confirmVisibility = !confirmVisibility
                    if(confirmVisibility){
                        confirmVisualTransformation = VisualTransformation.None
                        confirmTrailingIcon = Icons.Default.Favorite
                    } else {
                        confirmVisualTransformation = PasswordVisualTransformation()
                        confirmTrailingIcon = Icons.Default.FavoriteBorder
                    }
                },
                visualTransformation = confirmVisualTransformation)
            Spacer(Modifier.size(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Checkbox(checked = checked, onCheckedChange = {checked = it})
                Text(stringResource(Res.string.terms_and_conditions))
            }
        }){
            PrimaryButton(modifier = Modifier.fillMaxWidth(), onClick = {
                navigator.push(AdditionalInfoScreen())
            }, text = Res.string.create_account_button, trailingIcon = Res.drawable.arrow_right)
        }
    }
}