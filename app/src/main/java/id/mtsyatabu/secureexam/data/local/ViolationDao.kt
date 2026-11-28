package id.mtsyatabu.secureexam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ViolationDao {

    @Insert
    suspend fun insert(violation: ViolationEntity): Long

    @Query("SELECT * FROM violations ORDER BY occurred_at DESC")
    fun observeAll(): Flow<List<ViolationEntity>>

    @Query("SELECT COUNT(*) FROM violations")
    fun observeCount(): Flow<Int>
}
