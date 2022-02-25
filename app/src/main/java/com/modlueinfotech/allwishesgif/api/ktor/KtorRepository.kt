package com.modlueinfotech.allwishesgif.api.ktor

import com.google.gson.Gson
import com.modlueinfotech.allwishesgif.model.AppData
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import org.json.JSONArray
import org.json.JSONObject

object KtorRepository {
    private val BASE_URL = "https://www.mediafire.com/file/fc2uzlytlhwt6py/allWishes_jc.txt/file";
    suspend fun getKtorRepository() : AppData? {
        var appData: AppData? = null
        try {
//            appData = KtorClient.httpClient.get(BASE_URL)
            var mealsString: String = KtorClient.httpClient.get(BASE_URL)
            println( " GET APP DATA mealsString 1.1 " )
            val json = JSONArray(mealsString)
            println( " GET APP DATA mealsString 1 " +json )
            val gson = Gson()
            appData = gson.fromJson(mealsString, AppData::class.java)
            println( " GET APP DATA mealsString appData " +appData)
            return appData
        } catch (e: NoTransformationFoundException) {
            var mealsString: String = KtorClient.httpClient.get(BASE_URL)
            println( " GET APP DATA mealsString 1 " +mealsString )
            val gson = Gson()
            appData = gson.fromJson(mealsString, AppData::class.java)
            println( " GET APP DATA mealsString appData " +appData)
            return appData
        } finally {
            println("Meals: ${appData?.size}")
        }
        return appData
    }
//    suspend fun getString() : String? {
//        var appData: String? = null
//        try {
//            appData = KtorClient.httpClient.get(BASE_URL)
//        } catch (e: NoTransformationFoundException) {
//        } finally {
//        }
//        return appData
//    }
}