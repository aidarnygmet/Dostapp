package kz.aidar.dostap.presentation.screen_models

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import kz.aidar.dostap.data.models.AuthResult
import kz.aidar.dostap.data.util.Error
import kz.aidar.dostap.data.util.onError
import kz.aidar.dostap.data.util.onSuccess
import kz.aidar.dostap.domain.use_cases.LoginUseCase
class LogInScreenModel(private val loginUseCase: LoginUseCase): StateScreenModel<LogInScreenModel.State>(State.Init){
    sealed class State {
        data object Init : State()
        data object Loading : State()
        data class Error(val e: kz.aidar.dostap.data.util.Error): State()
        data class Result(val res: AuthResult) : State()
    }
    fun login(login: String, password: String) {
        screenModelScope.launch {
            mutableState.value = State.Loading
            val res = loginUseCase.execute(login, password)
            res.onSuccess {
                mutableState.value = State.Result(it)
            }
            res.onError {
                mutableState.value = State.Error(it)
            }
        }
    }

}