package com.funwithphotography.namephotooncake.util

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.ViewGroup
import androidx.navigation.NavController
import com.sm.newadlib.handlers.AdsHandler
import com.sm.newadlib.listeners.FullAdListener

object AdUtils {

    fun showEntryFullAd(activity: Activity, listener: AdListener) {
        AdsHandler.showEntryInterstitialAds(activity, object : FullAdListener {
            override fun onComplete(isAdDisplay: Boolean, adNetwork: String) {
                listener.onComplete()
            }
        })
    }

    fun showFullAd(activity: Activity, listener: AdListener) {
        AdsHandler.showInterstitialAds(activity, object : FullAdListener {
            override fun onComplete(isAdDisplay: Boolean, adNetwork: String) {
                listener.onComplete()
            }
        })
    }

    fun showBanner(activity: Activity, adContainer: ViewGroup) {
        AdsHandler.showBannerAd(activity, adContainer)
    }

    fun showLBanner(activity: Activity, adContainer: ViewGroup) {
        AdsHandler.showLBannerAd(activity, adContainer)
    }

    fun showMBanner(activity: Activity, adContainer: ViewGroup) {
        AdsHandler.showMedBannerAd(activity, adContainer)
    }

    fun showNativeBanner(activity: Activity, adContainer: ViewGroup) {
        AdsHandler.showNativeBannerAd(activity, adContainer)
    }

    fun showNative(activity: Activity, adContainer: ViewGroup) {
        AdsHandler.showNativeAd(activity, adContainer)
    }

    fun launchReview(activity: Activity) {
        AdsHandler.launchReviewPopup(activity, null)
    }

    interface AdListener {
        fun onComplete()
    }

    fun changeComposable(navController: NavController, composablePath: String) {
        AdsHandler.showInterstitialAds(com.modlueinfotech.allwishesgif.MainActivity.mainActivity, object : FullAdListener {
            override fun onComplete(isAdDisplay: Boolean, adNetwork: String) {
                var dTime = 500L
                if (adNetwork.equals("Mopub", ignoreCase = true)) {
                    dTime = 10
                }
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        try {
                            navController.navigate(composablePath){}
                        } catch (e: Exception) {
                        }
                    }, dTime
                )
            }
        })
    }

}