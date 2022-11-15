package com.ecotech.qrscrenner.repositories

import com.ecotech.qrscrenner.dao.MainDao
import com.ecotech.qrscrenner.network.APIServices
import com.ecotech.qrscrenner.network.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @Author: Nilesh Salunkhe
 * @Date: 18/10/22
 */


class MainRepository @Inject constructor(private val mainMainDao: MainDao,private val apiServices: APIServices) {

    suspend fun getEmployeeList()= flow {
        emit(NetworkResult.Loading(true))
        val response= apiServices.getEmployeeList()
        if (response.success){
            if (response.response.isEmpty()){
                emit(NetworkResult.Failure(response.message))
            }else{
                mainMainDao.addEmployeeAll(response.response)
//                for (employee in response.response){
//                    mainMainDao.addEmployee(employee)
//                }
            emit(NetworkResult.Success(response))
            }
        }else{
            emit(NetworkResult.Failure(response.message))
        }

    }.catch { e->
        emit(NetworkResult.Failure(e.message ?:"Oops Something Wrong"))
    }
}