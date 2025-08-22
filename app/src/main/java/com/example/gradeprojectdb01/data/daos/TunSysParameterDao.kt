package com.example.gradeprojectdb01.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import kotlinx.coroutines.flow.Flow

@Dao
interface TunSysParameterDao {
    //CREATE BLOCK
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTunSysParameter (tunSysParameter: TunSysParameter):Long

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTunSysParameters (tunSysParameters: List<TunSysParameter>): List<Long>

    //READ BLOCK

    @Query("SELECT * FROM TunSysParameter WHERE tunSysParamId = :tunSysParameterId")
    suspend fun getTunSysParameterById(tunSysParameterId: Long): TunSysParameter?

    @Query("SELECT * FROM TunSysParameter ORDER BY tunSysParamId ASC")
    suspend fun getAllTunSysParameters(): List<TunSysParameter>

    @Query("SELECT * FROM TunSysParameter WHERE tunSysParamId = :tunSysParameterId")
    fun observeTunSysParameterById(tunSysParameterId: Long): Flow<TunSysParameter?>

    @Query("SELECT * FROM TunSysParameter ORDER BY tunSysParamId ASC")
    fun observeAllTunSysParameters(): Flow<List<TunSysParameter>>

    //UPDATE BLOCK
    @Update
    suspend fun updateTunSysParam(tunSysParameter: TunSysParameter)

    @Update
    suspend fun updateTunSysParams(tunSysParameters: List<TunSysParameter>)

    @Query("UPDATE TunSysParameter SET value = :value WHERE tunSysParamId = :tunSysParameterId")
    suspend fun updateTunSysParamValue(tunSysParameterId: Long, value: String)

    //DELETE BLOCK
    @Delete
    suspend fun deleteTunSysParameter(tunSysParameter: TunSysParameter)

    @Query("DELETE FROM TunSysParameter WHERE tunSysParamId = :tunSysParameterId")
    suspend fun deleteTunSysParameterById(tunSysParameterId: Long)

    @Delete
    suspend fun deleteTunSysParameters(tunSysParameters: List<TunSysParameter>)

    @Query("DELETE FROM TunSysParameter WHERE tunSysParamId IN (:tunSysParamIds)")
    suspend fun deleteTunSysParametersByIds(tunSysParamIds: List<Long>)

    @Query("DELETE FROM TunSysParameter")
    suspend fun deleteAllTunSysParameters()
}