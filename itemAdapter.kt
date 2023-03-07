package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemAdapter(private val items: List<Item>) : RecyclerView.Adapter<itemAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val linkTextView: TextView
        val titleTextView: TextView
        val priceTextView: TextView

        init {
            linkTextView = itemView.findViewById(R.id.link_tv)
            titleTextView = itemView.findViewById(R.id.title_tv)
            priceTextView = itemView.findViewById(R.id.price_tv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.titleTextView.text = item.name
        holder.priceTextView.text = item.price
        holder.linkTextView.text = item.url

    }

    override fun getItemCount(): Int {
        return items.size
    }
}