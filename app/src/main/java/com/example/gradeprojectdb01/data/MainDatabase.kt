package com.example.gradeprojectdb01.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gradeprojectdb01.data.convertersAndEnums.TunSysParamTypeConverter
import com.example.gradeprojectdb01.data.daos.NoteDao
import com.example.gradeprojectdb01.data.daos.InstrumentDao
import com.example.gradeprojectdb01.data.daos.InstrumentNoteCrossRefDao
import com.example.gradeprojectdb01.data.daos.TunSysParameterDao
import com.example.gradeprojectdb01.data.daos.TuningSystemDao
import com.example.gradeprojectdb01.data.daos.TuningSystemNoteCrossRefDao
import com.example.gradeprojectdb01.data.entities.Note
import com.example.gradeprojectdb01.data.entities.Instrument
import com.example.gradeprojectdb01.data.entities.InstrumentNoteCrossRef
import com.example.gradeprojectdb01.data.entities.TunSysParameter
import com.example.gradeprojectdb01.data.entities.TuningSystem
import com.example.gradeprojectdb01.data.entities.TuningSystemNoteCrossRef

@Database(entities = [
    Instrument::class,
    TuningSystem::class,
    Note::class,
    TunSysParameter::class,
    InstrumentNoteCrossRef::class,
    TuningSystemNoteCrossRef::class
],
    version = 1, exportSchema = false)

@TypeConverters (TunSysParamTypeConverter::class)

abstract class MainDatabase : RoomDatabase(){

    abstract val profileDao: InstrumentDao
    abstract val tuningSystemDao: TuningSystemDao
    abstract val noteDao: NoteDao
    abstract val tunSysParameterDao: TunSysParameterDao
    abstract val profileNoteDao: InstrumentNoteCrossRefDao
    abstract val tuningSystemNoteDao: TuningSystemNoteCrossRefDao

    companion object {
        @Volatile
        private var INSTANCE : MainDatabase? = null

        fun getDatabaseInstance(context: Context): MainDatabase {
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "main_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}