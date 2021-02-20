package com.wisnuwahyudi.aplikasikuis.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.wisnuwahyudi.aplikasikuis.databinding.ActivitySplashScreenBinding
import com.wisnuwahyudi.aplikasikuis.kategorisoal.view.KategoriSoalActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, KategoriSoalActivity::class.java))
        },4000)

    }
}