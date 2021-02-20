package com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wisnuwahyudi.aplikasikuis.databinding.ItemsResultBinding

class PencapaianAdapter(
    val dataSiswa: ArrayList<String>,
    val dataBenar: ArrayList<String>,
    val noUrutSoal: ArrayList<Int>
) :
    RecyclerView.Adapter<PencapaianAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemsResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(jwbSiswa: String, jwbSistem: String,noSoal : Int) {
            with(binding) {
                txtJawabanKamu.text = jwbSiswa
                val info = "Jawaban Yang Benar : "
                toolsJawabanBenar.text = info
                txtJawabanBenar.text = jwbSistem
                val ket = "Jawaban soal no : $noSoal"
                toolsJwbNumber.text = ket

                if(jwbSiswa == jwbSistem){
                    imgCheckBenar.visibility = View.VISIBLE
                }else{
                    imgCheckWrong.visibility = View.VISIBLE
                }
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PencapaianAdapter.ViewHolder {
        val view =
            ItemsResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PencapaianAdapter.ViewHolder, position: Int) {
        val jawabanSiswa = dataSiswa?.get(position)
        val jawabanAkurat = dataBenar?.get(position)
        val numberSoal = noUrutSoal?.get(position)
        holder.bindData(jawabanSiswa, jawabanAkurat,numberSoal)
    }

    override fun getItemCount(): Int {
        return dataSiswa.size
    }
}