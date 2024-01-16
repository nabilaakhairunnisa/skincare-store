package com.nabila.skincarestore.data

import com.nabila.skincarestore.model.DataSource
import com.nabila.skincarestore.model.OrderSkincare
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class Repository {

    private val orderSkincare = mutableListOf<OrderSkincare>()

    init {
        if (orderSkincare.isEmpty()) {
            DataSource.dummySkincare.forEach {
                orderSkincare.add(OrderSkincare(it, 0))
            }
        }
    }

    fun getAllSkincare(): Flow<List<OrderSkincare>> {
        return flowOf(orderSkincare)
    }

    fun getOrderSkincareById(skincareId: Long): OrderSkincare {
        return orderSkincare.first {
            it.skincare.id == skincareId
        }
    }

    fun updateOrderSkincare(skincareId: Long, newCountValue: Int): Flow<Boolean> {
        val index = orderSkincare.indexOfFirst { it.skincare.id == skincareId }
        val result = if (index >= 0) {
            val orderSkincare = orderSkincare[index]
            this.orderSkincare[index] =
                orderSkincare.copy(skincare = orderSkincare.skincare, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderSkincare(): Flow<List<OrderSkincare>> {
        return getAllSkincare()
            .map { orderSkincare ->
                orderSkincare.filter { orderSkincare ->
                    orderSkincare.count != 0
                }
            }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(): Repository =
            instance ?: synchronized(this) {
                Repository().apply {
                    instance = this
                }
            }
    }
}