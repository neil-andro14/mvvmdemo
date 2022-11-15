package com.ecotech.qrscrenner.network

import com.ecotech.qrscrenner.network.WebServices.EmployeeList
import com.ecotech.qrscrenner.responses.EmployeeResponse
import retrofit2.http.GET

/**
 * @Author: Nilesh Salunkhe
 * @Date: 19/10/22
 */

interface APIServices {

    @GET(EmployeeList)
    suspend fun getEmployeeList(): EmployeeResponse

    
}