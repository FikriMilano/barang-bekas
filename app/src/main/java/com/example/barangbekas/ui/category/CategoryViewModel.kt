package com.example.barangbekas.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barangbekas.data.remote.model.ResponseProduct
import com.example.barangbekas.data.remote.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {

    private val _productsState = MutableStateFlow(ResponseProduct())
    val productsState = _productsState.asStateFlow()

    fun getProductsByCategory(categoryId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _productsState.update {
                RetrofitInstance.instance.getProductsByCategory(categoryId)
            }
        }
    }
}