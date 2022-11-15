package com.ecotech.qrscrenner.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: Nilesh Salunkhe
 * @Date: 08/11/22
 */


@Entity(tableName = "employee")
data class EmployeeEntity(
    var empEmail: String,
    var empId: String,
    var empMobile: Long,
    var empName: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var role: Int
)