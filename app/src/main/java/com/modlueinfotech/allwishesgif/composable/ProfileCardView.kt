package com.modlueinfotech.allwishesgif.composable

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AbstractComposeView
import androidx.navigation.NavController
import com.modlueinfotech.allwishesgif.MainActivity
import com.modlueinfotech.allwishesgif.utils.*
import com.mopub.common.util.ImageUtils
import java.io.File

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
    fun shareQuotes(view: ProfileCardView) {
        val bitmap = MyImageUtils.generateBitmap(view)
        AppUtilJava.getInstance().shareBitmap(MainActivity.mainActivity,bitmap,false)
    }
    fun shareQuotesWhatsapp(view: ProfileCardView) {
        val bitmap = MyImageUtils.generateBitmap(view)
        AppUtilJava.getInstance().shareBitmap(MainActivity.mainActivity,bitmap,true)
    }
    fun saveQuotesItem(view: ProfileCardView,navController: NavController?, context:Context, extension: String) {
        val bitmap = MyImageUtils.generateBitmap(view)
        val file = AppUtilJava.getInstance().getFile(context, bitmap)
        file.let {
            val direct = File(
                context.getExternalFilesDir(null).toString() + "/Collection"
            )
            if (!direct.exists()) {
                direct.mkdirs()
            }
            val f = File(direct.absolutePath, "" + System.currentTimeMillis() + extension)
            file?.copyTo(f)
            navController?.navigate(NavigationDestinations.downloadAlertScreen)
        }
    }
}