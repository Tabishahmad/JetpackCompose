package com.modlueinfotech.allwishesgif.composable

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AbstractComposeView
import com.modlueinfotech.allwishesgif.MainActivity
import com.modlueinfotech.allwishesgif.utils.AppUtilJava
import com.modlueinfotech.allwishesgif.utils.MyImageUtils
import com.modlueinfotech.allwishesgif.utils.ShareUtils
import com.mopub.common.util.ImageUtils

class ProfileCardView@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    var quote = mutableStateOf("")
    var title: String
        get() = quote.value
        set(value) {
            quote.value = value
        }
    var position = mutableStateOf(0)
    var colorIndex: Int
        get() = position.value
        set(value) {
            position.value = value
        }
    @Composable
    override fun Content() {
        // This is a ComposableUI function
        QuotesPreviewCard(quote.value,position.value)
    }
    fun capture(view: ProfileCardView) {
        val bitmap = MyImageUtils.generateBitmap(view)
        AppUtilJava.getInstance().shareBitmap(MainActivity.mainActivity,bitmap,true)
    }

}