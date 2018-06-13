package com.prueba.besil.theelectricfactoryprueba.ui.client.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.prueba.besil.theelectricfactoryprueba.R
import com.prueba.besil.theelectricfactoryprueba.data.network.DTO.ClientDTO

class ClientAdapter(var clientDTOList: List<ClientDTO>) : RecyclerView.Adapter<ClientAdapter.ViewHolder>() {
    var isLoading: Boolean = false

    override fun onBindViewHolder(holder: ClientAdapter.ViewHolder, position: Int) {
        holder.txtName?.text = clientDTOList[position].name
        holder.txtDirection?.text = clientDTOList[position].direction
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return clientDTOList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtDirection = itemView.findViewById<TextView>(R.id.txtDirection)
    }

}