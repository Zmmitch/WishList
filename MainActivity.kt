package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var  items: List<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        var myList = ArrayList<Item>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRv = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = itemAdapter(myList)
        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)


        val btn = findViewById<Button>(R.id.submitBtn)
        val price = findViewById<EditText>(R.id.price)
        val link = findViewById<EditText>(R.id.link)
        val item_name = findViewById<EditText>(R.id.item_name)
        btn.setOnClickListener() {
//            Item(item_name.text, price.text, link.text)
            addView(myList, item_name.text.toString(), price.text.toString(), link.text.toString())
            adapter.notifyDataSetChanged()
            price.text.clear()
            link.text.clear()
            item_name.text.clear()

        }

    }

    private fun addView(myList: ArrayList<Item>,  name: String, price: String, url: String) {
        myList.add(Item(name, price, url))
    }
}