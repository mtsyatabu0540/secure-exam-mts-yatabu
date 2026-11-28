package id.mtsyatabu.secureexam.security

enum class SecurityStatus { INACTIVE, ACTIVE }

/**
 * Modul Security Manager. Kontrak ini sengaja minimal dan akan dilengkapi
 * pada tahap Security Manager (FLAG_SECURE, screen pinning, deteksi pelanggaran).
 */
interface SecurityManager {
    fun currentStatus(): SecurityStatus
}

/** Implementasi sementara tahap 1: selalu melaporkan status belum aktif. */
class PlaceholderSecurityManager : SecurityManager {
    override fun currentStatus(): SecurityStatus = SecurityStatus.INACTIVE
}
