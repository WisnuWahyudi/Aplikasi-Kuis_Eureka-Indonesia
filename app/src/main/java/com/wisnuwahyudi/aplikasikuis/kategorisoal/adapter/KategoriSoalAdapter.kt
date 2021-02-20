package com.wisnuwahyudi.aplikasikuis.kategorisoal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wisnuwahyudi.aplikasikuis.databinding.ItemKategoriSoalBinding
import com.wisnuwahyudi.aplikasikuis.kategorisoal.model.DataItem

class KategoriSoalAdapter(val dataCategory: List<DataItem?>?, val iClick : ClickListener ) :
    RecyclerView.Adapter<KategoriSoalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KategoriSoalAdapter.ViewHolder {
        val view =
            ItemKategoriSoalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    interface ClickListener{
        fun action(data : DataItem)
    }

    override fun onBindViewHolder(holder: KategoriSoalAdapter.ViewHolder, position: Int) {
        val category = dataCategory?.get(position)
        holder.bindData(category)
    }

    override fun getItemCount(): Int {
        return dataCategory?.size ?: 0
    }

    inner class ViewHolder(val binding: ItemKategoriSoalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: DataItem?) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data?.image)
                    .into(imgCategory)

                txtKategoriSoal.text = data?.name

                itemView.setOnClickListener {

                 if (data != null) {
                     iClick.action(data)
                 }

                }
            }
        }

    }
}