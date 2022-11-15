package com.ecotech.qrscrenner.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: Nilesh Salunkhe
 * @Date: 13/10/22
 */

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "user_name")
    val userName: String ="",
    @ColumnInfo(name = "user_email")
    val userEmail: String=""
)
