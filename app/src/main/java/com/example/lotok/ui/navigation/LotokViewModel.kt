package com.example.lotok.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.lotok.LotokApplication
import com.example.lotok.data.LotokRepository
import com.example.lotok.model.Category
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface LotokUiState {
    data class Success(val photos: List<Category>) : LotokUiState
    object Error : LotokUiState
    object Loading : LotokUiState
}

class LotokViewModel(private val lotokRepository: LotokRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var lotokUiState: LotokUiState by mutableStateOf(LotokUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getLotokCategories()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getLotokCategories() {
        viewModelScope.launch {
            lotokUiState = LotokUiState.Loading
            lotokUiState = try {
                LotokUiState.Success(lotokRepository.getLotokCategories())
            } catch (e: IOException) {
                LotokUiState.Error
            } catch (e: HttpException) {
                LotokUiState.Error
            }
        }
    }

    /**
     * Factory for [MarsViewModel] that takes [MarsPhotosRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LotokApplication)
                val lotokRepository = application.container.lotokRepository
                LotokViewModel(lotokRepository = lotokRepository)
            }
        }
    }
}