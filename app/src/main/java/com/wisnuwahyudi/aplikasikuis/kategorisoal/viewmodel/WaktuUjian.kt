package com.wisnuwahyudi.aplikasikuis.kategorisoal.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WaktuUjian : ViewModel() {

    fun calculate(){
        val timer = MyCounter(60000*5, 1000)
        timer.start()
    }

    var waktu = MutableLiveData<String>()

    var showLive : LiveData<String> = waktu


   inner class MyCounter(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {

        override fun onFinish() {
            println("Timer Completed.")
        }


        override fun onTick(millisUntilFinished: Long) {
            var detik = (millisUntilFinished / 1000).toString()

            waktu.value = "$detik Detik "

            println("Timer  : " + millisUntilFinished / 1000)
        }
    }
}