package id.mtsyatabu.secureexam.ui.common

import android.graphics.Color
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

/**
 * Target SDK 35 ke atas memaksa tampilan edge-to-edge.
 * Status bar memakai latar navy (ikon terang); navigation bar memakai latar putih (ikon gelap).
 */
fun ComponentActivity.configureEdgeToEdge() {
    enableEdgeToEdge(
        statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
        navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
    )
}

/** Menambahkan inset system bar (kiri, kanan, bawah) ke padding awal view. */
fun View.applySystemBarInsetsAsPadding() {
    val initialLeft = paddingLeft
    val initialRight = paddingRight
    val initialBottom = paddingBottom
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val bars = insets.getInsets(
            WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout(),
        )
        view.updatePadding(
            left = initialLeft + bars.left,
            right = initialRight + bars.right,
            bottom = initialBottom + bars.bottom,
        )
        insets
    }
}
