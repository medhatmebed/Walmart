package com.example.walmart

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.cardviewlayout.view.*

class ProductsAdapater: BaseAdapter {
    var productsList = ArrayList<Product>()
    var context : Context? = null

    //give the context and the dataSource to the Adapter constructor
    constructor(context: Context, productList: ArrayList<Product>) : super() {
        this.context = context
        this.productsList = productList
    }
    //return the cell view to be reusable
    override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
        var product = productsList[index]
        var inflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var productView = inflater.inflate(R.layout.cardviewlayout, null)
        productView.imageView.setImageResource(product.image)
        productView.textView.text = product.name
        return productView

    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //return number of cell itiration
    override fun getCount(): Int {
        return productsList.size
    }

}