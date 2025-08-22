package com.example.gradeprojectdb01.data.daos

import android.net.IpSecAlgorithm
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.relations.NoteWithInstruments
import com.example.gradeprojectdb01.data.relations.NoteWithTuningSystems
import com.example.gradeprojectdb01.data.relations.TuningSystemWithInstruments
import com.example.gradeprojectdb01.data.relations.TuningSystemWithNotes
import com.example.gradeprojectdb01.data.relations.TuningSystemWithParameters
import kotlinx.coroutines.flow.Flow

@Dao
interface TuningSystemDao {

    // CREATE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTuningSystem(tuningSystem: TuningSystem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTuningSystems(tuningSystem: List<TuningSystem>): List<Long>

    // READ
    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    suspend fun getTuningSystemById(tunSysId: Long): TuningSystem?

    @Query("SELECT * FROM TuningSystem ORDER BY tunSysId ASC")
    suspend fun getAllTuningSystems(): List<TuningSystem>

    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    fun observeTuningSystemById(tunSysId: Long): Flow<TuningSystem?>

    @Query("SELECT * FROM TuningSystem ORDER BY tunSysId ASC")
    fun observeAllTuningSystems(): Flow<List<TuningSystem>>

    // Relations
    @Transaction
    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    suspend fun getTuningSystemWithInstruments(tunSysId: Long): TuningSystemWithInstruments?

    @Transaction
    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    suspend fun getTuningSystemWithNotes(tunSysId: Long): TuningSystemWithNotes?

    @Transaction
    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    suspend fun getTuningSystemWithParameters(tunSysId: Long): TuningSystemWithParameters?

    @Transaction
    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    fun observeTuningSystemWithInstruments(tunSysId: Long): Flow<TuningSystemWithInstruments?>

    @Transaction
    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    fun observeTuningSystemWithNotes(tunSysId: Long): Flow<TuningSystemWithNotes?>

    @Transaction
    @Query("SELECT * FROM TuningSystem WHERE tunSysId = :tunSysId")
    fun observeTuningSystemWithParameters(tunSysId: Long): Flow<TuningSystemWithParameters?>

    // UPDATE
    @Update
    suspend fun updateTuningSystem(tuningSystem: TuningSystem)

    @Update
    suspend fun updateTuningSystems(tuningSystems: List<TuningSystem>)

    @Query("UPDATE TuningSystem SET algorithm = :algorithm WHERE tunSysId = :tunSysId")
    suspend fun updateTuningSystemAlgorithm(tunSysId: Long, algorithm: String)

    // DELETE
    @Delete
    suspend fun deleteTuningSystem(tuningSystem: TuningSystem)

    @Delete
    suspend fun deleteTuningSystems(tuningSystems: List<TuningSystem>)

    @Query("DELETE FROM TuningSystem WHERE tunSysId = :tunSysId")
    suspend fun deleteTuningSystemById(tunSysId: Long)

    @Query("DELETE FROM TuningSystem")
    suspend fun deleteAllTuningSystems()
}