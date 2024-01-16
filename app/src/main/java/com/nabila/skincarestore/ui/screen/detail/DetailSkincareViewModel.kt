package com.nabila.skincarestore.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nabila.skincarestore.data.Repository
import com.nabila.skincarestore.model.OrderSkincare
import com.nabila.skincarestore.model.Skincare
import com.nabila.skincarestore.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailSkincareViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderSkincare>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderSkincare>>
        get() = _uiState

    fun getSkincareById(skincareId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderSkincareById(skincareId))
        }
    }

    fun addToCart(skincare: Skincare, count: Int) {
        viewModelScope.launch {
            repository.updateOrderSkincare(skincare.id, count)
        }
    }
}