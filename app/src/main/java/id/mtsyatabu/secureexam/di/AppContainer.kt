package id.mtsyatabu.secureexam.di

import android.content.Context
import id.mtsyatabu.secureexam.data.local.AppDatabase
import id.mtsyatabu.secureexam.data.repository.ViolationRepository
import id.mtsyatabu.secureexam.security.PlaceholderSecurityManager
import id.mtsyatabu.secureexam.security.SecurityManager

/**
 * Penyedia dependency manual (tanpa library DI) agar kerangka tetap ringan.
 * Seluruh objek dibuat lazy sehingga hanya dibuat saat pertama dipakai.
 */
class AppContainer(context: Context) {

    private val appContext = context.applicationContext

    private val database: AppDatabase by lazy { AppDatabase.create(appContext) }

    val violationRepository: ViolationRepository by lazy {
        ViolationRepository(database.violationDao())
    }

    val securityManager: SecurityManager by lazy { PlaceholderSecurityManager() }
}
