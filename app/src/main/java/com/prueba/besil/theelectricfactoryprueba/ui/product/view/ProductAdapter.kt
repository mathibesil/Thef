package com.prueba.besil.theelectricfactoryprueba.ui.product.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.prueba.besil.theelectricfactoryprueba.R
import com.prueba.besil.theelectricfactoryprueba.data.network.DTO.ProductDTO

class ProductAdapter(var productDTOList: List<ProductDTO>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    var isLoading: Boolean = false

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.txtName?.text = productDTOList[position].nombre
        holder.txtDirection?.text = productDTOList[position].precio.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return productDTOList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtDirection = itemView.findViewById<TextView>(R.id.txtDirection)
    }

}