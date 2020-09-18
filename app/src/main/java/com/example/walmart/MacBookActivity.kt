package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mac_book.*

class MacBookActivity : AppCompatActivity() , OnProductClickListener {

    lateinit var productlist: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mac_book)

        productlist = ArrayList()
        addProduct()
        rv_electronic.layoutManager = LinearLayoutManager(this)
        rv_electronic.addItemDecoration(DividerItemDecoration(this,1))
        rv_electronic.adapter = ElectronicAdapter(productlist, this)
    }

    fun addProduct() {
        productlist.add(Product("MacBook Air", price = 2500.00,color =  "Red and white", image = R.drawable.machbook,desc =  "new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now"))
        productlist.add(Product("Note 20",  price =1700.99,color = "Black and white",image = R.drawable.machbook,desc =  "The introduction of a Note 20 Ultra is set to redefine what the Note means for Samsung and where the Note 20 sits amongst other flagship phones The introduction of a Note 20 Ultra is set to redefine what the Note means for Samsung and where the Note 20 sits amongst other flagship phones The introduction of a Note 20 Ultra is set to redefine what the Note means for Samsung and where the Note 20 sits amongst other flagship phones The introduction of a Note 20 Ultra is set to redefine what the Note means for Samsung and where the Note 20 sits amongst other flagship phones"))
        productlist.add(Product("Mac Book Pro",  price =2500.50,color = "Sliver",image = R.drawable.machbook,desc =  "All the usual premium MacBook hardware flourishes return in 2020: you’re getting a really large trackpad that’s the best in the industry; The best monitor in 2020 for gaming and developer with higest resolution Note 20 Ultra is set to redefine what the Note means new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now"))
        productlist.add(Product("New aripod2",  price =700.88,color = "Black",image = R.drawable.machbook,desc =  "The best monitor in 2020 for gaming and developer with higest resolution. new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now"))
        productlist.add(Product("Gaming Monitor", price = 1700.88,color = "Black",image = R.drawable.iphone,desc =  "The best monitor in 2020 for gaming and developer with higest resolution. new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now"))
        productlist.add(Product("iPad Pro 2020",  price =999.88, color ="Black",image = R.drawable.imac,desc =  "The best monitor in 2020 for gaming and developer with higest resolution. new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now"))
        productlist.add(Product("Dell XPS", price = 1900.99,color = "Black",image = R.drawable.machbook,desc = "The best monitor in 2020 for gaming and developer with higest resolution. new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now"))
        productlist.add(Product("Airpod",  price =450.99,color = "Red and black",image = R.drawable.machbook, desc = "The best monitor in 2020 for gaming and developer with higest resolution. new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now new iPhone 12 release news has now all but confirmed further delays to the range new iPhone 12 release news has now"))
    }

    override fun onItemClick(item: Product, position: Int) {
        //Toast.makeText(this, item.title , Toast.LENGTH_SHORT).show()
        var intent = Intent(this, MacBookDetailActivity::class.java)
        intent.putExtra("Product_Title", item.name)
        intent.putExtra("Product_Description", item.description)
        intent.putExtra("Product_Color", item.color)
        intent.putExtra("Product_Image", item.image.toString())
        startActivity(intent)
    }
}