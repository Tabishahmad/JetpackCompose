package com.modlueinfotech.allwishesgif.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
class SingalNode(){
    private val category_name: String? = null
    private val cicon: String? = null
    private val gif: List<Gif> = ArrayList<Gif>()
    private val image: List<Image> = ArrayList<Image>()
    private val quotes: List<Quote> = ArrayList<Quote>()

    fun getCategory_name(): String? {
        return category_name
    }
    fun getCicon(): String? {
        return cicon
    }
    fun getGif(): List<Gif?>? {
        return gif
    }
    fun getImage(): List<Image?>? {
        return image
    }
    fun getQuotes(): List<Quote?>? {
        return quotes
    }
}