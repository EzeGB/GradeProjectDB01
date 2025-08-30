package com.example.gradeprojectdb01.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gradeprojectdb01.data.entities.TuningSystemNote

@Dao
interface TuningSystemNoteDao {
    //CREATE BLOCK
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNote)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTunSysNoteCrossRefs(tunSystemNoteCrossRef: List<TuningSystemNote>)

    //UPDATE
    @Query("UPDATE TuningSystemNote SET name = :name WHERE noteId = :noteId" +
            " AND tunSysId = :tunSysId")
    suspend fun updateNoteName(noteId: Long, tunSysId: Long,name:String)

    @Query("UPDATE TuningSystemNote SET alteration = :alteration WHERE noteId = :noteId"+
            " AND tunSysId = :tunSysId")
    suspend fun updateNoteAlteration(noteId: Long, tunSysId: Long, alteration:String)

    //DELETE BLOCK
    @Delete
    suspend fun deleteTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNote)

    @Delete
    suspend fun deleteTunSysNoteCrossRefs(tunSysNoteCrossRef: List<TuningSystemNote>)

    @Query(
        "DELETE FROM TuningSystemNote " +
            "WHERE tunSysId = :tunSysId AND noteId = :noteId")
    suspend fun deleteTunSysNoteCrossRefByIds(tunSysId: Long, noteId:Long)

    @Query("DELETE FROM TuningSystemNote WHERE tunSysId = :tunSysId")
    suspend fun deleteAllTunSysNoteCrossRefByTunSysId(tunSysId: Long)

    @Query("DELETE FROM TuningSystemNote WHERE noteId = :noteId")
    suspend fun deleteAllTunSysNoteCrossRefByNoteId(noteId:Long)

    @Query("DELETE FROM TuningSystemNote")
    suspend fun deleteAllTunSysNoteCrossRefs()
}