package com.example.gradeprojectdb01.data.repositories

import com.example.gradeprojectdb01.data.daos.TunSysParameterDao
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import kotlinx.coroutines.flow.Flow

class TunSysParameterRepository(private val tunSysParameterDao: TunSysParameterDao) {

    // CREATE
    suspend fun insertTunSysParameter(tunSysParameter: TunSysParameter): Long {
        return tunSysParameterDao.insertTunSysParameter(tunSysParameter)
    }

    suspend fun insertAllTunSysParameters(tunSysParameters: List<TunSysParameter>): List<Long> {
        return tunSysParameterDao.insertAllTunSysParameters(tunSysParameters)
    }

    // READ
    suspend fun getTunSysParameterById(tunSysParameterId: Long): TunSysParameter? {
        return tunSysParameterDao.getTunSysParameterById(tunSysParameterId)
    }

    suspend fun getAllTunSysParameters(): List<TunSysParameter> {
        return tunSysParameterDao.getAllTunSysParameters()
    }

    fun observeTunSysParameterById(tunSysParameterId: Long): Flow<TunSysParameter?> {
        return tunSysParameterDao.observeTunSysParameterById(tunSysParameterId)
    }

    fun observeAllTunSysParameters(): Flow<List<TunSysParameter>> {
        return tunSysParameterDao.observeAllTunSysParameters()
    }

    // UPDATE
    suspend fun updateTunSysParam(tunSysParameter: TunSysParameter) {
        tunSysParameterDao.updateTunSysParam(tunSysParameter)
    }

    suspend fun updateTunSysParams(tunSysParameters: List<TunSysParameter>) {
        tunSysParameterDao.updateTunSysParams(tunSysParameters)
    }

    suspend fun updateTunSysParamValue(tunSysParameterId: Long, value: String) {
        tunSysParameterDao.updateTunSysParamValue(tunSysParameterId, value)
    }

    // DELETE
    suspend fun deleteTunSysParameter(tunSysParameter: TunSysParameter) {
        tunSysParameterDao.deleteTunSysParameter(tunSysParameter)
    }

    suspend fun deleteTunSysParameterById(tunSysParameterId: Long) {
        tunSysParameterDao.deleteTunSysParameterById(tunSysParameterId)
    }

    suspend fun deleteTunSysParameters(tunSysParameters: List<TunSysParameter>) {
        tunSysParameterDao.deleteTunSysParameters(tunSysParameters)
    }

    suspend fun deleteTunSysParametersByIds(tunSysParamIds: List<Long>) {
        tunSysParameterDao.deleteTunSysParametersByIds(tunSysParamIds)
    }

    suspend fun deleteAllTunSysParameters() {
        tunSysParameterDao.deleteAllTunSysParameters()
    }
}