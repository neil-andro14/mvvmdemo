package com.ecotech.qrscrenner.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ecotech.qrscrenner.entities.EmployeeEntity

/**
 * @Author: Nilesh Salunkhe
 * @Date: 08/11/22
 */
class EmployeeListAdapter(private val employeeList: ArrayList<EmployeeEntity>): RecyclerView.Adapter<QRViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QRViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: QRViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount()= employeeList.size
}


class QRViewHolder(itemView: View):ViewHolder(itemView) {

}
