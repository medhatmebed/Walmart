package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mac_book_detail.*

class MacBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mac_book_detail)
        var productTitle = intent.getStringExtra("Product_Title")
        var productDescription = intent.getStringExtra("Product_Description")
        var productImage = intent.getStringExtra("Product_Image")?.toInt()
        var productColor = intent.getStringExtra("Product_Color")
        //Toast.makeText(this, productImage, Toast.LENGTH_SHORT).show()
        product_title.text = productTitle
        product_description.text = productDescription
        product_color.text = productColor
        if (productImage != null) {
            image_1.setImageResource(productImage)
        }
    }
}