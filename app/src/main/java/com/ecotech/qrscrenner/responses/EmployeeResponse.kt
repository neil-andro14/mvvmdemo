package com.ecotech.qrscrenner.responses

import com.ecotech.qrscrenner.entities.EmployeeEntity

data class EmployeeResponse(
    var message: String,
    var response: ArrayList<EmployeeEntity>,
    var success: Boolean
)