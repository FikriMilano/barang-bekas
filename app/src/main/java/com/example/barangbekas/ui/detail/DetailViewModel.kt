package com.example.barangbekas.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barangbekas.data.remote.model.Category
import com.example.barangbekas.data.remote.model.ResponseCategory
import com.example.barangbekas.data.remote.model.ResponseProduct
import com.example.barangbekas.data.remote.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _categoryState: MutableStateFlow<Category?> = MutableStateFlow(Category())
    val categoryState = _categoryState.asStateFlow()

    fun getCategoryById(categoryId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _categoryState.update {
                RetrofitInstance.instance.getCategoryById(categoryId).data.firstOrNull()
            }
        }
    }
}