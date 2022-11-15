package com.ecotech.qrscrenner.dao

import androidx.room.Dao
import androidx.room.Insert
import com.ecotech.qrscrenner.entities.EmployeeEntity

/**
 * @Author: Nilesh Salunkhe
 * @Date: 08/11/22
 */
@Dao
interface EmployeeDao {

    @Insert
    suspend fun addEmployee(employeeEntity: EmployeeEntity)
}