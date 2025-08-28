package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.TuningSystemDao
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.relations.TuningSystemWithInstruments
import com.example.gradeprojectdb01.data.relations.TuningSystemWithNotes
import com.example.gradeprojectdb01.data.relations.TuningSystemWithParameters
import kotlinx.coroutines.flow.Flow

class TuningSystemRepository(private val tuningSystemDao: TuningSystemDao) {

    // CREATE
    suspend fun insertTuningSystem(tuningSystem: TuningSystem): Long {
        return tuningSystemDao.insertTuningSystem(tuningSystem)
    }

    suspend fun insertAllTuningSystems(tuningSystems: List<TuningSystem>): List<Long> {
        return tuningSystemDao.insertAllTuningSystems(tuningSystems)
    }

    // READ
    suspend fun getTuningSystemById(tunSysId: Long): TuningSystem? {
        return tuningSystemDao.getTuningSystemById(tunSysId)
    }

    suspend fun getAllTuningSystems(): List<TuningSystem> {
        return tuningSystemDao.getAllTuningSystems()
    }

    fun observeTuningSystemById(tunSysId: Long): Flow<TuningSystem?> {
        return tuningSystemDao.observeTuningSystemById(tunSysId)
    }

    fun observeAllTuningSystems(): Flow<List<TuningSystem>> {
        return tuningSystemDao.observeAllTuningSystems()
    }

    // RELATIONS
    suspend fun getTuningSystemWithInstruments(tunSysId: Long): TuningSystemWithInstruments? {
        return tuningSystemDao.getTuningSystemWithInstruments(tunSysId)
    }

    suspend fun getTuningSystemWithNotes(tunSysId: Long): TuningSystemWithNotes? {
        return tuningSystemDao.getTuningSystemWithNotes(tunSysId)
    }

    suspend fun getTuningSystemWithParameters(tunSysId: Long): TuningSystemWithParameters? {
        return tuningSystemDao.getTuningSystemWithParameters(tunSysId)
    }

    fun observeTuningSystemWithInstruments(tunSysId: Long): Flow<TuningSystemWithInstruments?> {
        return tuningSystemDao.observeTuningSystemWithInstruments(tunSysId)
    }

    fun observeTuningSystemWithNotes(tunSysId: Long): Flow<TuningSystemWithNotes?> {
        return tuningSystemDao.observeTuningSystemWithNotes(tunSysId)
    }

    fun observeTuningSystemWithParameters(tunSysId: Long): Flow<TuningSystemWithParameters?> {
        return tuningSystemDao.observeTuningSystemWithParameters(tunSysId)
    }

    // UPDATE
    suspend fun updateTuningSystem(tuningSystem: TuningSystem) {
        tuningSystemDao.updateTuningSystem(tuningSystem)
    }

    suspend fun updateTuningSystems(tuningSystems: List<TuningSystem>) {
        tuningSystemDao.updateTuningSystems(tuningSystems)
    }

    suspend fun updateTuningSystemAlgorithm(tunSysId: Long, algorithm: String) {
        tuningSystemDao.updateTuningSystemAlgorithm(tunSysId, algorithm)
    }

    // DELETE
    suspend fun deleteTuningSystem(tuningSystem: TuningSystem) {
        tuningSystemDao.deleteTuningSystem(tuningSystem)
    }

    suspend fun deleteTuningSystemById(tunSysId: Long) {
        tuningSystemDao.deleteTuningSystemById(tunSysId)
    }

    suspend fun deleteTuningSystems(tuningSystems: List<TuningSystem>) {
        tuningSystemDao.deleteTuningSystems(tuningSystems)
    }

    suspend fun deleteTuningSystemsByIds(tunSysIds: List<Long>) {
        tuningSystemDao.deleteTuningSystemsByIds(tunSysIds)
    }

    suspend fun deleteAllTuningSystems() {
        tuningSystemDao.deleteAllTuningSystems()
    }
}