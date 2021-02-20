package com.wisnuwahyudi.aplikasikuis.kategorisoal.presenter

import com.wisnuwahyudi.aplikasikuis.kategorisoal.model.DataItem

interface IviewKategoriSoal {
    fun DataIsSuccess(dataCategory : List<DataItem?>?)
    fun LoadFailed(msg : String)
}