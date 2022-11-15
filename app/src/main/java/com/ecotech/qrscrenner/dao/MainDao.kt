package com.ecotech.qrscrenner.dao

import androidx.room.Dao
import androidx.room.Insert
import com.ecotech.qrscrenner.entities.EmployeeEntity

/**
 * @Author: Nilesh Salunkhe
 * @Date: 18/10/22
 */
@Dao
interface MainDao {

    @Insert
    suspend fun addEmployee(employeeEntity: EmployeeEntity)

    @Insert
    suspend fun addEmployeeAll(employeeEntity: ArrayList<EmployeeEntity>)
}