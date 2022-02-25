//package com.example.allwishescompose.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.allwishescompose.api.ktor.KtorRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.launch
//
//class CategoryViewModel : ViewModel() {
//    val categoryData = MutableStateFlow<CategoryData?>(null)
//    init {
//        viewModelScope.launch {
//            kotlin.runCatching {
//                KtorRepository.getCategoryData("")
//            }.onSuccess {
//                categoryData.value = it
//            }.onFailure {
//                categoryData.value = null
//            }
//        }
//    }
//}