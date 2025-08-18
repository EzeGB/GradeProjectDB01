package com.example.gradeprojectdb01.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gradeprojectdb01.data.daos.NoteDao
import com.example.gradeprojectdb01.data.daos.ProfileDao
import com.example.gradeprojectdb01.data.daos.ProfileNoteCrossRefDao
import com.example.gradeprojectdb01.data.daos.SystemParameterDao
import com.example.gradeprojectdb01.data.daos.TuningSystemDao
import com.example.gradeprojectdb01.data.daos.TuningSystemNoteCrossRefDao
import com.example.gradeprojectdb01.data.models.Note
import com.example.gradeprojectdb01.data.models.Profile
import com.example.gradeprojectdb01.data.models.ProfileNoteCrossRef
import com.example.gradeprojectdb01.data.models.SystemParameter
import com.example.gradeprojectdb01.data.models.TuningSystem
import com.example.gradeprojectdb01.data.models.TuningSystemNoteCrossRef

@Database(entities = [
    Profile::class,
    TuningSystem::class,
    Note::class,
    SystemParameter::class,
    ProfileNoteCrossRef::class,
    TuningSystemNoteCrossRef::class
],
    version = 1, exportSchema = false)

abstract class MainDatabase : RoomDatabase(){

    abstract val profileDao: ProfileDao
    abstract val tuningSystemDao: TuningSystemDao
    abstract val noteDao: NoteDao
    abstract val systemParameterDao: SystemParameterDao
    abstract val profileNoteDao: ProfileNoteCrossRefDao
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