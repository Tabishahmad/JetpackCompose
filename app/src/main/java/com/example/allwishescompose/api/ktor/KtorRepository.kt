package com.example.allwishescompose.api.ktor

import com.example.allwishescompose.model.AppData
import com.example.allwishescompose.model.SingalNode
import com.google.gson.Gson
import io.ktor.client.call.*
import io.ktor.client.request.*

object KtorRepository {
    private val BASE_URL = "https://www.mediafire.com/file/nmfsy0m287dt2rs/allWishes_jc.txt/file";
    suspend fun getKtorRepository() : AppData? {
        var appData: AppData? = null
        try {
            appData = KtorClient.httpClient.get(BASE_URL)
        } catch (e: NoTransformationFoundException) {
            var mealsString: String = KtorClient.httpClient.get(BASE_URL)
            val gson = Gson()
            appData = gson.fromJson(mealsString, AppData::class.java)
            return appData
        } finally {
            println("Meals: ${appData?.size}")
        }
        return null
    }
}