package com.modlueinfotech.allwishesgif.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modlueinfotech.allwishesgif.api.ktor.KtorRepository
import com.modlueinfotech.allwishesgif.model.AppData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    val freeGamesFlow = MutableStateFlow<AppData?>(null)
    lateinit var string: String
    init {
        viewModelScope.launch {
            kotlin.runCatching {
                KtorRepository.getKtorRepository()
            }.onSuccess {
                freeGamesFlow.value = it
                println( " GET APP DATA onSuccess " + freeGamesFlow.value)
            }.onFailure {
                freeGamesFlow.value = null
                println( " GET APP DATA onFailure " + freeGamesFlow.value)
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
//                KtorRepository.getString()
//            }.onSuccess {
//                if (it != null) {
//                    string = it
//                }
//            }.onFailure {
//                string = null.toString()
//            }
//        }
//    }
}