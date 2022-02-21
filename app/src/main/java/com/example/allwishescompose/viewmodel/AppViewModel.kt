package com.example.allwishescompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allwishescompose.api.ktor.KtorRepository
import com.example.allwishescompose.model.AppData
import com.example.allwishescompose.model.SingalNode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    val freeGamesFlow = MutableStateFlow<AppData?>(null)
    init {
        viewModelScope.launch {
            kotlin.runCatching {
                KtorRepository.getKtorRepository()
            }.onSuccess {
                freeGamesFlow.value = it
            }.onFailure {
                freeGamesFlow.value = null
            }
        }
    }
//    fun loadCategorydata(cDataURL:String): MutableLiveData<Resource<CategoryData?>> {
//        if(categoryData == null ) {
//            categoryData = loadCategorydataOnce(cDataURL) as MutableLiveData<Resource<CategoryData?>>
//        }
//        return categoryData as MutableLiveData<Resource<CategoryData?>>
//    }
//    private fun loadCategorydataOnce(cDataURL: String) = liveData(Dispatchers.IO)   {
//        categoryName = cDataURL
//        emit(Resource.loading(data = null))
//        try {
//            emit(Resource.success(data = KtorRepository.getCategoryData(cDataURL)))
//        }catch (e: Exception){
//            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
//        }
//    }
//    fun loadCategorydataOnce(cDataURL:String) {
//        viewModelScope.launch {
//            kotlin.runCatching {
//                KtorRepository.getCategoryData(cDataURL)
//            }.onSuccess {
//                _categoryData.value = it
//            }.onFailure {
//                _categoryData.value = null
//            }
//        }
//    }
}