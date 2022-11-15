package com.ecotech.qrscrenner.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ecotech.qrscrenner.dao.MainDao
import com.ecotech.qrscrenner.entities.EmployeeEntity
import com.ecotech.qrscrenner.entities.UserEntity

/**
 * @Author: Nilesh Salunkhe
 * @Date: 13/10/22
 */

@Database(entities = [UserEntity::class, EmployeeEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mainDao(): MainDao
}