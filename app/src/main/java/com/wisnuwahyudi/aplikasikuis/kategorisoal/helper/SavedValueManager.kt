package com.wisnuwahyudi.aplikasikuis.kategorisoal.helper

import android.content.Context
import android.content.SharedPreferences

class SavedValueManager(var context : Context?) {

    var preference : SharedPreferences ?= null
    var editor : SharedPreferences.Editor ?= null
    var PREF_NAME = "TeamPenilaian"

    val sessionJawabanSiswa__  = "aa"
    val sessionJawbanSiswa2 = "KEY_TWO"
    val sessionJawbanSiswa3 = "KEY_THREE"
    val sessionJawbanSiswa4 = "KEY_FOUR"
    val sessionJawbanSiswa5 = "KEY_FIVE"
    val ID_CATEGORY = "ID_ID"


    init{
        preference = context?.getSharedPreferences(PREF_NAME,0)
        editor = preference?.edit()
    }

    var idc : Int ?
    get() = preference?.getInt(ID_CATEGORY,0)
    set(value) {
        if (value != null) {
            editor?.putInt(ID_CATEGORY,value)
        }
        editor?.commit()
    }

    var siswa_one : String?
    get() = preference?.getString(sessionJawabanSiswa__,"Kamu belum menjawab soal")
    set(value) {
        editor?.putString(sessionJawabanSiswa__,value)
        editor?.commit()
    }

    var siswa_two : String?
    get() = preference?.getString(sessionJawbanSiswa2,"Kamu belum menjawab soal")
    set(value) {
        editor?.putString(sessionJawbanSiswa2,value)
        editor?.commit()
    }

    var siswa_three : String?
        get() = preference?.getString(sessionJawbanSiswa3,"Kamu belum menjawab soal")
        set(value) {
            editor?.putString(sessionJawbanSiswa3 ,value)
            editor?.commit()
        }

    var siswa_four : String?
        get() = preference?.getString(sessionJawbanSiswa4,"Kamu belum menjawab soal")
        set(value) {
            editor?.putString(sessionJawbanSiswa4,value)
            editor?.commit()
        }

    var siswa_five : String?
        get() = preference?.getString(sessionJawbanSiswa5 ,"Kamu belum menjawab soal")
        set(value) {
            editor?.putString(sessionJawbanSiswa5 ,value)
            editor?.commit()
        }

  fun clearCache(){
      editor?.clear()
      editor?.commit()
  }


}