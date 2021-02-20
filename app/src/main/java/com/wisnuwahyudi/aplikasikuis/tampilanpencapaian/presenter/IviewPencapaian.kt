package com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.presenter

interface IviewPencapaian {
    fun calculateResult(benar : Int,skor : Int,salah : Int)
    fun jawabanSiswaDanSistem(resultSiswa : ArrayList<String>,resultSistem : ArrayList<String>,noUrutSoal : ArrayList<Int>)
}