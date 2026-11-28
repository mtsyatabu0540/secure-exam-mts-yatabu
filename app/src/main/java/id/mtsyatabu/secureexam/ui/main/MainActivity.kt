package id.mtsyatabu.secureexam.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import id.mtsyatabu.secureexam.R
import id.mtsyatabu.secureexam.databinding.ActivityMainBinding
import id.mtsyatabu.secureexam.security.SecurityStatus
import id.mtsyatabu.secureexam.ui.alert.AlertToneTestActivity
import id.mtsyatabu.secureexam.ui.common.applySystemBarInsetsAsPadding
import id.mtsyatabu.secureexam.ui.common.configureEdgeToEdge
import id.mtsyatabu.secureexam.ui.history.ViolationHistoryActivity
import id.mtsyatabu.secureexam.ui.pin.PinSettingsActivity
import id.mtsyatabu.secureexam.ui.scan.ScanQrActivity
import id.mtsyatabu.secureexam.ui.security.SecurityStatusActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels { MainViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.scrollContent.applySystemBarInsetsAsPadding()

        binding.cardScanQr.setOnClickListener { open(ScanQrActivity::class.java) }
        binding.cardSecurityStatus.setOnClickListener { open(SecurityStatusActivity::class.java) }
        binding.cardViolationHistory.setOnClickListener { open(ViolationHistoryActivity::class.java) }
        binding.cardAlertTone.setOnClickListener { open(AlertToneTestActivity::class.java) }
        binding.cardPinSettings.setOnClickListener { open(PinSettingsActivity::class.java) }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { render(it) }
            }
        }
    }

    private fun open(target: Class<*>) {
        startActivity(Intent(this, target))
    }

    private fun render(state: MainUiState) {
        binding.tvSecurityStatus.setText(
            when (state.securityStatus) {
                SecurityStatus.INACTIVE -> R.string.security_status_inactive
                SecurityStatus.ACTIVE -> R.string.security_status_active
            },
        )
        binding.tvViolationCount.text =
            getString(R.string.dashboard_violation_count, state.violationCount)
    }
}
