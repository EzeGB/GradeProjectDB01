package com.example.gradeprojectdb01.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef

@Dao
interface TuningSystemNoteCrossRefDao {
    //CREATE BLOCK
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNoteCrossRef)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTunSysNoteCrossRefs(tunSystemNoteCrossRef: List<TuningSystemNoteCrossRef>)

    //DELETE BLOCK
    @Delete
    suspend fun deleteTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNoteCrossRef)

    @Delete
    suspend fun deleteTunSysNoteCrossRefs(tunSysNoteCrossRef: List<TuningSystemNoteCrossRef>)

    @Query("DELETE FROM TuningSystemNoteCrossRef " +
            "WHERE tunSysId = :tunSysId AND noteId = :noteId")
    suspend fun deleteTunSysNoteCrossRefByIds(tunSysId: Long, noteId:Long)

    @Query("DELETE FROM TuningSystemNoteCrossRef WHERE tunSysId = :tunSysId")
    suspend fun deleteAllTunSysNoteCrossRefByTunSysId(tunSysId: Long)

    @Query("DELETE FROM TuningSystemNoteCrossRef WHERE noteId = :noteId")
    suspend fun deleteAllTunSysNoteCrossRefByNoteId(noteId:Long)

    @Query("DELETE FROM TuningSystemNoteCrossRef")
    suspend fun deleteAllTunSysNoteCrossRefs()
}