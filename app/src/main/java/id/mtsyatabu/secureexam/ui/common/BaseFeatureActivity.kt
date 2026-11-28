package id.mtsyatabu.secureexam.ui.common

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import id.mtsyatabu.secureexam.databinding.ActivityFeaturePlaceholderBinding

/**
 * Dasar halaman fitur yang belum diimplementasikan.
 * Setiap fitur cukup menentukan judul dan deskripsinya; halaman diganti penuh pada tahap fiturnya.
 */
abstract class BaseFeatureActivity : AppCompatActivity() {

    @get:StringRes
    protected abstract val screenTitleRes: Int

    @get:StringRes
    protected abstract val screenDescriptionRes: Int

    private lateinit var binding: ActivityFeaturePlaceholderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureEdgeToEdge()
        binding = ActivityFeaturePlaceholderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.contentContainer.applySystemBarInsetsAsPadding()

        val title = getString(screenTitleRes)
        binding.toolbar.title = title
        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.tvFeatureTitle.text = title
        binding.tvFeatureDescription.setText(screenDescriptionRes)
    }
}
