package com.wisnuwahyudi.aplikasikuis.tampilankuis.view

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.wisnuwahyudi.aplikasikuis.R
import com.wisnuwahyudi.aplikasikuis.databinding.ActivityTampilanKuisBinding
import com.wisnuwahyudi.aplikasikuis.kategorisoal.helper.SavedValueManager
import com.wisnuwahyudi.aplikasikuis.kategorisoal.model.DataItem
import com.wisnuwahyudi.aplikasikuis.kategorisoal.viewmodel.WaktuUjian
import com.wisnuwahyudi.aplikasikuis.tampilankuis.adapter.SectionsPagerAdapter
import com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.view.PencapaianActivity

class TampilanKuisActivity : AppCompatActivity() {

    companion object{
        const val key_id_category = "1998"
        const val context = "CTX"
    }

    private lateinit var binding : ActivityTampilanKuisBinding
    private lateinit var viewModel : WaktuUjian

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilanKuisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(WaktuUjian::class.java)
        viewModel.calculate()

        viewModel.showLive.observe(this, Observer {

            if(it == "0 Detik "){
                 Toast.makeText(this,"Waktu habis !",Toast.LENGTH_LONG).show()
                    val move = Intent(this,PencapaianActivity::class.java)
                    startActivity(move)
                    finish()

            }else{
                binding.txtWaktu.text = it
            }
        })

        val accData = intent?.getParcelableExtra<DataItem>(TampilanKuisActivity.key_id_category)

        val session = SavedValueManager(this)
        session.idc = accData?.iD?.toInt()

        binding.txtJenisSoal.text = accData?.name

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        supportActionBar?.elevation = 0f

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        binding.fbSelesai.setOnClickListener {

            AlertDialog.Builder(this@TampilanKuisActivity).apply {
                setTitle("Mengumpulkan Soal Ujian")
                setMessage("Yakin ingin mengumpulkan jawaban ujian ?")
                setPositiveButton("Yakin 100 %"){ dialog, which ->
                    val move = Intent(this@TampilanKuisActivity,PencapaianActivity::class.java)
                    startActivity(move)
                    finish()
                    dialog.dismiss()
                }
                setNegativeButton("Saya Ragu"){ dialog,which ->
                    dialog.dismiss()
                }
            }.show()

        }

    }
}