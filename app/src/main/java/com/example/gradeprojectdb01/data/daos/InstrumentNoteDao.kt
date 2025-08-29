package com.example.gradeprojectdb01.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gradeprojectdb01.data.entities.InstrumentNote

@Dao
interface InstrumentNoteDao {
    //CREATE BLOCK
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInstNoteCrossRef(instNoteCrossRef: InstrumentNote)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllInstNoteCrossRefs(instNoteCrossRef: List<InstrumentNote>)

    //UPDATE
    @Query("UPDATE InstrumentNote SET name = :name WHERE noteId = :noteId" +
            " AND instrumentId = :instrumentId")
    suspend fun updateNoteName(noteId: Long, instrumentId: Long,name:String)

    @Query("UPDATE InstrumentNote SET alteration = :alteration WHERE noteId = :noteId"+
    " AND instrumentId = :instrumentId")
    suspend fun updateNoteAlteration(noteId: Long, instrumentId: Long, alteration:String)

    //DELETE BLOCK
    @Delete
    suspend fun deleteInstNoteCrossRef(instNoteCrossRef: InstrumentNote)

    @Delete
    suspend fun deleteInstNoteCrossRefs(instNoteCrossRef: List<InstrumentNote>)

    @Query(
        "DELETE FROM InstrumentNote " +
            "WHERE instrumentId = :instrumentId AND noteId = :noteId")
    suspend fun deleteInstNoteCrossRefByIds(instrumentId: Long, noteId:Long)

    @Query("DELETE FROM InstrumentNote WHERE instrumentId = :instrumentId")
    suspend fun deleteAllInstNoteCrossRefByInstrumentId(instrumentId: Long)

    @Query("DELETE FROM InstrumentNote WHERE noteId = :noteId")
    suspend fun deleteAllInstNoteCrossRefByNoteId(noteId:Long)

    @Query("DELETE FROM InstrumentNote")
    suspend fun deleteAllInstNoteCrossRefs()
}