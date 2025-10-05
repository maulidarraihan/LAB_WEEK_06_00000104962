package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CatViewHolder>() {

    // List buat nyimpen data kucing
    private val cats = mutableListOf<CatModel>()

    // Fungsi buat ganti data lama ke data baru
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)

        // Kasih tahu adapter kalo data berubah → biar UI ke-update
        notifyDataSetChanged()
    }

    // Bikin ViewHolder baru (nge-inflate layout item_list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader)
    }

    // Ngasih tau berapa banyak item di list
    override fun getItemCount() = cats.size

    // Ngebind data ke tiap ViewHolder
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }
}
