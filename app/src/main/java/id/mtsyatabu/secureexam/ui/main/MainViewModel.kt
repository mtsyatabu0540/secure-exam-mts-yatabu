package id.mtsyatabu.secureexam.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.mtsyatabu.secureexam.SecureExamApp
import id.mtsyatabu.secureexam.data.repository.ViolationRepository
import id.mtsyatabu.secureexam.security.SecurityManager
import id.mtsyatabu.secureexam.security.SecurityStatus
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class MainUiState(
    val securityStatus: SecurityStatus,
    val violationCount: Int,
)

class MainViewModel(
    violationRepository: ViolationRepository,
    private val securityManager: SecurityManager,
) : ViewModel() {

    val uiState: StateFlow<MainUiState> = violationRepository.observeViolationCount()
        .map { count -> MainUiState(securityManager.currentStatus(), count) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainUiState(securityManager.currentStatus(), 0),
        )

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SecureExamApp
                MainViewModel(
                    violationRepository = app.container.violationRepository,
                    securityManager = app.container.securityManager,
                )
            }
        }
    }
}
