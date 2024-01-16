package com.nabila.skincarestore.ui.screen.cart

import com.nabila.skincarestore.model.OrderSkincare

data class CartState(
    val orderSkincare: List<OrderSkincare>,
    val totalPrice: Int
)