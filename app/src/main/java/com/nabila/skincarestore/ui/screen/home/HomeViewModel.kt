package com.nabila.skincarestore.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nabila.skincarestore.data.Repository
import com.nabila.skincarestore.model.OrderSkincare
import com.nabila.skincarestore.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderSkincare>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderSkincare>>>
        get() = _uiState

    fun getAllSkincare() {
        viewModelScope.launch {
            repository.getAllSkincare()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderSkincare ->
                    _uiState.value = UiState.Success(orderSkincare)
                }
        }
    }
}