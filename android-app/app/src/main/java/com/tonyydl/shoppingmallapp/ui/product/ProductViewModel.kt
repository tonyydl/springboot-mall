package com.tonyydl.shoppingmallapp.ui.product

import androidx.lifecycle.viewModelScope
import com.tonyydl.shoppingmallapp.BaseViewModel
import com.tonyydl.shoppingmallapp.repository.ProductRepository
import com.tonyydl.shoppingmallapp.service.RetrofitManager
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductViewModel : BaseViewModel<ProductUiState, ProductUiEvent>() {
    override fun setInitialState(): ProductUiState = ProductUiState()

    private val productRepository by lazy { ProductRepository(RetrofitManager.productService) }

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val page = productRepository.getProducts()
                state = state.copy(
                    productList = page.results.map { it.transform() }
                )
            } catch (e: Exception) {
                // TODO: handle exception
            }
            state = state.copy(isLoading = false)
        }
    }
}