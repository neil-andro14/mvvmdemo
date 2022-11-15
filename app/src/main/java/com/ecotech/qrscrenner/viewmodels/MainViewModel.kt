package com.ecotech.qrscrenner.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecotech.qrscrenner.network.NetworkResult
import com.ecotech.qrscrenner.repositories.MainRepository
import com.ecotech.qrscrenner.responses.EmployeeResponse
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Nilesh Salunkhe
 * @Date: 18/10/22
 */

@HiltViewModel

class MainViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    private var _movieResponse = MutableLiveData<NetworkResult<EmployeeResponse>>()
    val movieResponse: LiveData<NetworkResult<EmployeeResponse>> = _movieResponse

    init {
        fetchAllMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            mainRepository.getEmployeeList().collect {
                _movieResponse.postValue(it)
            }
        }
    }
}