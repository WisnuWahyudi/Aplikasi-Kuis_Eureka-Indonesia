package com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wisnuwahyudi.aplikasikuis.databinding.ActivityPencapaianBinding
import com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.adapter.PencapaianAdapter
import com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.presenter.IviewPencapaian
import com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.presenter.PencapaianPresenter

class PencapaianActivity : AppCompatActivity(), IviewPencapaian {

    private lateinit var binding : ActivityPencapaianBinding
    private lateinit var presenter : PencapaianPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPencapaianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = PencapaianPresenter(this)
        presenter.resultExam(this)

    }

    override fun calculateResult(benar: Int, skor: Int, salah: Int) {
        binding.txtBenar.text = benar.toString()
        binding.txtSalah.text = salah.toString()
        binding.txtSkor.text = skor.toString()
    }

    override fun jawabanSiswaDanSistem(
        resultSiswa: ArrayList<String>,
        resultSistem: ArrayList<String>,
        noUrutSoal: ArrayList<Int>
    ) {
        val adapterData = PencapaianAdapter(resultSiswa,resultSistem,noUrutSoal)

        with(binding.rvResultPencapaian) {
            setHasFixedSize(true)
            adapter = adapterData
        }

    }
    
}