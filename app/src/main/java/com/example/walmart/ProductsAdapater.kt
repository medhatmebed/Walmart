package com.example.walmart

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Intent
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
        if (product.name.equals("Apple Watch") || product.name.equals("MacBook Pro")) {
            productView.imageView.setOnClickListener{
                makeSomeIntents(context,product.name)
            }
        }
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
    //make some intents
    fun makeSomeIntents(context: Context?,destination : String){

//        val intent = Intent(getActivity(),Shopping::class.java)
//        intent.putExtra("userName",user.email)
//        startActivity(intent)
        if (destination.equals("Apple Watch")){
            val intent = Intent(context,AppleWatch::class.java)
            context?.startActivity(intent)
        }else {
            val intent = Intent(context,MacBookActivity::class.java)
            context?.startActivity(intent)
        }
    }

}