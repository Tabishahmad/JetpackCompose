package com.modlueinfotech.allwishesgif.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.funwithphotography.namephotooncake.util.AdUtils
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView
import com.modlueinfotech.allwishesgif.MainActivity
import com.modlueinfotech.allwishesgif.R

object AppUtils {
    fun isNetWorking(context: Context): Boolean{
        var isConnected = false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            isConnected = when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                activeNetworkInfo?.run {
                    isConnected = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }
                }
            }
        }
        return isConnected
    }
    fun showMessage(context: Context, str: String) {
//        val snackbar = Snackbar.make(MainActivity.mainActivity, str, Snackbar.LENGTH_SHORT)
//        snackbar.view.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
//        snackbar.view.findViewById<TextView>(R.id.snackbar_text).setTextColor(Color.BLACK)
//        snackbar.show()
        Toast.makeText(context,str,Toast.LENGTH_LONG).show()
    }
}