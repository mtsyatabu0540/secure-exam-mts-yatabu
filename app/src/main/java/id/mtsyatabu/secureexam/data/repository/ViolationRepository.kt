package id.mtsyatabu.secureexam.data.repository

import id.mtsyatabu.secureexam.data.local.ViolationDao
import kotlinx.coroutines.flow.Flow

class ViolationRepository(private val dao: ViolationDao) {

    fun observeViolationCount(): Flow<Int> = dao.observeCount()
}
