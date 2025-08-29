package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.TuningSystemNoteCrossRefDao
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef

class TuningSystemNoteCrossRefRepository(
    private val tuningSystemNoteCrossRefDao: TuningSystemNoteCrossRefDao
) {

    // CREATE
    suspend fun insertTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNoteCrossRef) {
        tuningSystemNoteCrossRefDao.insertTunSysNoteCrossRef(tunSysNoteCrossRef)
    }

    suspend fun insertAllTunSysNoteCrossRefs(tunSysNoteCrossRefs: List<TuningSystemNoteCrossRef>) {
        tuningSystemNoteCrossRefDao.insertAllTunSysNoteCrossRefs(tunSysNoteCrossRefs)
    }

    // DELETE
    suspend fun deleteTunSysNoteCrossRef(tunSysNoteCrossRef: TuningSystemNoteCrossRef) {
        tuningSystemNoteCrossRefDao.deleteTunSysNoteCrossRef(tunSysNoteCrossRef)
    }

    suspend fun deleteTunSysNoteCrossRefs(tunSysNoteCrossRefs: List<TuningSystemNoteCrossRef>) {
        tuningSystemNoteCrossRefDao.deleteTunSysNoteCrossRefs(tunSysNoteCrossRefs)
    }

    suspend fun deleteTunSysNoteCrossRefByIds(tunSysId: Long, noteId: Long) {
        tuningSystemNoteCrossRefDao.deleteTunSysNoteCrossRefByIds(tunSysId, noteId)
    }

    suspend fun deleteAllTunSysNoteCrossRefByTunSysId(tunSysId: Long) {
        tuningSystemNoteCrossRefDao.deleteAllTunSysNoteCrossRefByTunSysId(tunSysId)
    }

    suspend fun deleteAllTunSysNoteCrossRefByNoteId(noteId: Long) {
        tuningSystemNoteCrossRefDao.deleteAllTunSysNoteCrossRefByNoteId(noteId)
    }

    suspend fun deleteAllTunSysNoteCrossRefs() {
        tuningSystemNoteCrossRefDao.deleteAllTunSysNoteCrossRefs()
    }
}
