package com.wisnuwahyudi.aplikasikuis.kategorisoal.presenter

import com.wisnuwahyudi.aplikasikuis.kategorisoal.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class KategoriSoalPresenter(val iCategory : IviewKategoriSoal){

    fun showCategoryFromServer(){
        ConfigNetwork.getNetwork().getDataCategory()
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it.isSuccess == true){
                    iCategory.DataIsSuccess(it.data)
                }else{
                    iCategory.LoadFailed(it.message.toString())
                }
            },{
                    iCategory.LoadFailed(it.message.toString())
            })
    }
}