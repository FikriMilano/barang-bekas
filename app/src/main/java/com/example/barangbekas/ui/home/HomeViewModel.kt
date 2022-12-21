package com.example.barangbekas.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barangbekas.data.remote.model.ResponseCategory
import com.example.barangbekas.data.remote.model.ResponseProduct
import com.example.barangbekas.data.remote.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _productsState = MutableStateFlow(ResponseProduct())
    val productsState = _productsState.asStateFlow()

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _productsState.update {
                RetrofitInstance.instance.getProducts()
            }
        }
    }

    private val _categoriesState = MutableStateFlow(ResponseCategory())
    val categoriesState = _categoriesState.asStateFlow()

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            _categoriesState.update {
                RetrofitInstance.instance.getCategories()
            }
        }
    }
}