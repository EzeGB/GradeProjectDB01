package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.InstrumentDao
import com.example.gradeprojectdb01.data.entities.Instrument
import com.example.gradeprojectdb01.data.relations.InstrumentWithNotes
import kotlinx.coroutines.flow.Flow

class InstrumentRepository(private val instrumentDao: InstrumentDao) {

    // CREATE
    suspend fun insertInstrument(instrument: Instrument): Long {
        return instrumentDao.insertInstrument(instrument)
    }

    suspend fun insertAllInstruments(instruments: List<Instrument>): List<Long> {
        return instrumentDao.insertAllInstruments(instruments)
    }

    // READ
    suspend fun getInstrumentById(instrumentId: Long): Instrument? {
        return instrumentDao.getInstrumentById(instrumentId)
    }

    suspend fun getAllInstruments(): List<Instrument> {
        return instrumentDao.getAllInstruments()
    }

    fun observeInstrumentById(instrumentId: Long): Flow<Instrument?> {
        return instrumentDao.observeInstrumentById(instrumentId)
    }

    fun observeAllInstruments(): Flow<List<Instrument>> {
        return instrumentDao.observeAllInstruments()
    }

    // RELATIONS
    suspend fun getInstrumentWithNotes(instrumentId: Long): InstrumentWithNotes? {
        return instrumentDao.getInstrumentWithNotes(instrumentId)
    }

    fun observeInstrumentWithNotes(instrumentId: Long): Flow<InstrumentWithNotes?> {
        return instrumentDao.observeInstrumentWithNotes(instrumentId)
    }

    // UPDATE
    suspend fun updateInstrument(instrument: Instrument) {
        instrumentDao.updateInstrument(instrument)
    }

    suspend fun updateInstruments(instruments: List<Instrument>) {
        instrumentDao.updateInstruments(instruments)
    }

    suspend fun updateInstrumentTunSys(instrumentId: Long, tunSysId: Long) {
        instrumentDao.updateInstrumentTunSys(instrumentId, tunSysId)
    }

    suspend fun updateInstrumentName(instrumentId: Long, name: String) {
        instrumentDao.updateInstrumentName(instrumentId, name)
    }

    // DELETE
    suspend fun deleteInstrument(instrument: Instrument) {
        instrumentDao.deleteInstrument(instrument)
    }

    suspend fun deleteById(instrumentId: Long) {
        instrumentDao.deleteById(instrumentId)
    }

    suspend fun deleteInstruments(instruments: List<Instrument>) {
        instrumentDao.deleteInstruments(instruments)
    }

    suspend fun deleteInstrumentsByIds(instrumentIds: List<Long>) {
        instrumentDao.deleteInstrumentsByIds(instrumentIds)
    }

    suspend fun deleteAllInstruments() {
        instrumentDao.deleteAllInstruments()
    }
}