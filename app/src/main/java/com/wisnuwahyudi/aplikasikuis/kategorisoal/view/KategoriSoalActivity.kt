package com.wisnuwahyudi.aplikasikuis.kategorisoal.view

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.wisnuwahyudi.aplikasikuis.databinding.ActivityKategoriSoalBinding
import com.wisnuwahyudi.aplikasikuis.kategorisoal.adapter.KategoriSoalAdapter
import com.wisnuwahyudi.aplikasikuis.kategorisoal.helper.SavedValueManager
import com.wisnuwahyudi.aplikasikuis.kategorisoal.model.DataItem
import com.wisnuwahyudi.aplikasikuis.kategorisoal.presenter.IviewKategoriSoal
import com.wisnuwahyudi.aplikasikuis.kategorisoal.presenter.KategoriSoalPresenter
import com.wisnuwahyudi.aplikasikuis.tampilankuis.view.TampilanKuisActivity

class KategoriSoalActivity : AppCompatActivity(), IviewKategoriSoal {

    private lateinit var binding: ActivityKategoriSoalBinding
    private lateinit var presenter: KategoriSoalPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKategoriSoalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = KategoriSoalPresenter(this)
        presenter.showCategoryFromServer()

        val session = SavedValueManager(this)
        session.clearCache()

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

    }


    override fun DataIsSuccess(dataCategory: List<DataItem?>?) {
        val adapterCategory =
            KategoriSoalAdapter(dataCategory, object : KategoriSoalAdapter.ClickListener {
                override fun action(data: DataItem) {
                    val intent = Intent(this@KategoriSoalActivity,TampilanKuisActivity::class.java)
                    intent.putExtra(TampilanKuisActivity.key_id_category,data)
                    startActivity(intent)
                }
            })

        with(binding.rvKategoriSoal) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = adapterCategory
        }
    }

    override fun LoadFailed(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}