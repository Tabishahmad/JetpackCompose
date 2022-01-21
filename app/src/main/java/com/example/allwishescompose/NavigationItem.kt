package com.example.allwishescompose

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object more_apps : NavigationItem("more", R.drawable.ic_more_apps, "More Apps")
    object rate_us : NavigationItem("rate", R.drawable.ic_rate_us, "Rate US")
    object privacy_policy : NavigationItem("privacy", R.drawable.ic_pp, "Privacy Police")
    object share : NavigationItem("share", R.drawable.ic_share_app, "Share")
}
