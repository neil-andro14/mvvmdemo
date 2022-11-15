package com.ecotech.qrscrenner

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecotech.qrscrenner.databinding.ActivityMainBinding
import com.ecotech.qrscrenner.network.NetworkResult
import com.ecotech.qrscrenner.viewmodels.MainViewModel
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var barcodeScanner: BarcodeScanner
    private val TAG= MainActivity::class.java.simpleName
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEmployeeRecyclerView()

        mainViewModel.movieResponse.observe(this){
            when(it){
                is NetworkResult.Loading ->{
                    Log.e(TAG, "onCreate: isLoading", )
                }
                is NetworkResult.Failure ->{
                    Log.e(TAG, "onCreate: Error ${it.errorMessage}", )
                }
                is NetworkResult.Success->{
                    Log.e(TAG, "onCreate: Data is ==> ${it.data}" )
                }
            }
        }
    }

    private fun initEmployeeRecyclerView() {
        binding.rvEmployeeList.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }
}