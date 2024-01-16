package com.nabila.skincarestore.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nabila.skincarestore.data.Repository
import com.nabila.skincarestore.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderSkincare() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderSkincare()
                .collect { orderSkincare ->
                    val totalPrice =
                        orderSkincare.sumOf { it.skincare.price * it.count }
                    _uiState.value = UiState.Success(CartState(orderSkincare, totalPrice))
                }
        }
    }

    fun updateOrderSkincare(skincareId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateOrderSkincare(skincareId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderSkincare()
                    }
                }
        }
    }
}