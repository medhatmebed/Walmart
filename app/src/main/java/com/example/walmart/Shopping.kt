package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shopping.*

class Shopping : AppCompatActivity() {

    var productsAdapter : ProductsAdapater? = null
    var productsList = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        productsList.add(Product("Apple Watch",R.drawable.iwatch,"Black", 199.00,""))
        productsList.add(Product("MacBook Pro",R.drawable.machbook, "Space Gray", 2000.00,""))
        productsList.add(Product("iPhone",R.drawable.iphone,"Gold",1199.00,""))
        productsList.add(Product("iMac",R.drawable.imac,"Silver",5000.00,""))

        //initialize the productsAdapter
        productsAdapter = ProductsAdapater(this,productsList)

        //set the gridView.adapter = you productsAdapter
        gridView.adapter = productsAdapter

        //get the intent parameter
        getUserName()
    }


    fun getUserName(){
        val intent = getIntent()
        val str = intent.getStringExtra("userName")
        userNameTxtView.text = "Welcome " + str + "!"

    }
}