package com.example.gradeprojectdb01.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gradeprojectdb01.data.entities.InstrumentNoteCrossRef

@Dao
interface InstrumentNoteCrossRefDao {
    //CREATE BLOCK
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInstNoteCrossRef(instNoteCrossRef: InstrumentNoteCrossRef)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllInstNoteCrossRefs(instNoteCrossRef: List<InstrumentNoteCrossRef>)

    //DELETE BLOCK
    @Delete
    suspend fun deleteInstNoteCrossRef(instNoteCrossRef: InstrumentNoteCrossRef)

    @Delete
    suspend fun deleteInstNoteCrossRefs(instNoteCrossRef: List<InstrumentNoteCrossRef>)

    @Query("DELETE FROM InstrumentNoteCrossRef " +
            "WHERE instrumentId = :instrumentId AND noteId = :noteId")
    suspend fun deleteInstNoteCrossRefByIds(instrumentId: Long, noteId:Long)

    @Query("DELETE FROM InstrumentNoteCrossRef WHERE instrumentId = :instrumentId")
    suspend fun deleteAllInstNoteCrossRefByInstrumentId(instrumentId: Long)

    @Query("DELETE FROM InstrumentNoteCrossRef WHERE noteId = :noteId")
    suspend fun deleteAllInstNoteCrossRefByNoteId(noteId:Long)

    @Query("DELETE FROM InstrumentNoteCrossRef")
    suspend fun deleteAllInstNoteCrossRefs()
}