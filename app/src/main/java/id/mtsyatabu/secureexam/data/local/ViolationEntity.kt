package id.mtsyatabu.secureexam.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Satu catatan kejadian yang dianggap indikasi pelanggaran. Disimpan lokal saja. */
@Entity(tableName = "violations")
data class ViolationEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "session_id") val sessionId: String?,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "occurred_at") val occurredAtMillis: Long,
)
