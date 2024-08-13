package kz.aidar.dostap.presentation.screens.screens.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dostap.composeapp.generated.resources.Res
import dostap.composeapp.generated.resources.arrow_right
import dostap.composeapp.generated.resources.clear
import dostap.composeapp.generated.resources.email
import dostap.composeapp.generated.resources.password
import kz.aidar.dostap.presentation.components.LabelText
import kz.aidar.dostap.presentation.components.PrimaryButton
import kz.aidar.dostap.presentation.components.PrimaryTextInput
import kz.aidar.dostap.presentation.components.RegistrationScreenTemplate
import kz.aidar.dostap.presentation.components.SecondaryButton
import kz.aidar.dostap.presentation.screens.screens.MainScreen

class LoginScreen:Screen {
    @Composable
    override fun Content() {
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
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
        val navigator = LocalNavigator.currentOrThrow
        RegistrationScreenTemplate(
            topPart = {
                LabelText("Nice to see you again")
                Spacer(Modifier.size(16.dp))
                PrimaryTextInput(
                    modifier = Modifier.fillMaxWidth(), value = email, onValueChanged = {
                    email = it
                },
                    leadingIcon = Res.drawable.email, trailingIcon = Res.drawable.clear, label = "Email address", onTrailingIconClicked = {
                    email = ""
                })
                Spacer(Modifier.size(16.dp))
                PrimaryTextInput(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChanged = {
                        password = it
                    }, label = "Password", leadingIcon = Res.drawable.password, trailingIcon = Res.drawable.clear,
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
                ClickableText(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline,
                                color = MaterialTheme.colors.primary,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        ){
                            append("Forgot password?")
                        }
                    }
                ){

                }

        },
            bottomPart = {
                PrimaryButton(modifier = Modifier.fillMaxWidth(), onClick = {
                    navigator.push(MainScreen())
                }, text = "Log in", trailingIcon = Res.drawable.arrow_right)
                Spacer(Modifier.size(16.dp))
                SecondaryButton(modifier = Modifier.fillMaxWidth(), onClick = {
                    navigator.push(RegistrationScreen())
                }, text = "I don't have an account")
        })
    }
}