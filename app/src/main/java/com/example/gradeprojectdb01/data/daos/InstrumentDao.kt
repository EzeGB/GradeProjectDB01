package com.example.gradeprojectdb01.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.gradeprojectdb01.data.entities.Instrument
import com.example.gradeprojectdb01.data.relations.InstrumentWithNotes
import kotlinx.coroutines.flow.Flow

@Dao
interface InstrumentDao {
    //CREATE BLOCK
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertInstrument(instrument: Instrument):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllInstruments(instruments: List<Instrument>): List<Long>

    //READ BLOCK
    @Query("SELECT * FROM Instrument WHERE instrumentId = :instrumentId")
    suspend fun getInstrumentById(instrumentId: Long): Instrument?

    @Query("SELECT * FROM Instrument ORDER BY instrumentId ASC")
    suspend fun getAllInstruments(): List<Instrument>

    @Query("SELECT * FROM Instrument WHERE instrumentId = :instrumentId")
    fun observeInstrumentById(instrumentId: Long): Flow<Instrument?>

    @Query("SELECT * FROM Instrument ORDER BY instrumentId ASC")
    fun observeAllInstruments(): Flow<List<Instrument>>

    //Relations
    @Transaction
    @Query("SELECT * FROM Instrument WHERE instrumentId = :instrumentId")
    suspend fun getInstrumentWithNotes(instrumentId:Long): InstrumentWithNotes?

    @Transaction
    @Query("SELECT * FROM Instrument WHERE instrumentId = :instrumentId")
    fun observeInstrumentWithNotes(instrumentId:Long): Flow<InstrumentWithNotes?>

    //UPDATE BLOCK
    @Update
    suspend fun updateInstrument(instrument: Instrument)

    @Update
    suspend fun updateInstruments(instruments: List<Instrument>)

    @Query("UPDATE Instrument SET tunSysId = :tunSysId WHERE instrumentId = :instrumentId")
    suspend fun updateInstrumentTunSys (instrumentId: Long, tunSysId:Long)

    @Query("UPDATE Instrument SET name = :name WHERE instrumentId = :instrumentId")
    suspend fun updateInstrumentName(instrumentId: Long, name:String)

    //DELETE BLOCK
    @Delete
    suspend fun deleteInstrument(instrument: Instrument)

    @Delete
    suspend fun deleteInstruments(instruments: List<Instrument>)

    @Query("DELETE FROM Instrument WHERE instrumentId = :instrumentId")
    suspend fun deleteById(instrumentId: Long)

    @Query("DELETE FROM Instrument")
    suspend fun deleteAllInstruments()
}