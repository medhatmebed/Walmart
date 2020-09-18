package com.example.walmart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.macbook_item.view.*


class ElectronicAdapter(var item: ArrayList<Product>, var clickListener: OnProductClickListener) : RecyclerView.Adapter<ElectronicViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectronicViewHolder {
        var electronicViewHolder: ElectronicViewHolder
        electronicViewHolder = ElectronicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.macbook_item, parent, false))
        return electronicViewHolder
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ElectronicViewHolder, position: Int) {
        /*
        holder.productTitle?.text = item.get(position).title
        holder.productPrice?.text = item.get(position).price.toString()
        holder.productColor?.text = item.get(position).color
        holder.productImage.setImageResource(item.get(position).image) */
        holder.intialize(item.get(position), clickListener)

    }

}

class ElectronicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var productTitle = itemView.product_title
    var productPrice = itemView.prduct_price
    var productColor = itemView.prduct_color
    var productImage = itemView.product_image

    fun intialize(item: Product, action:OnProductClickListener){
        productTitle.text = item.name
        productImage.setImageResource(item.image)
        productPrice.text = item.price.toString()
        productColor.text = item.color

        itemView.setOnClickListener {
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnProductClickListener {
    fun onItemClick(item: Product, position: Int)
}