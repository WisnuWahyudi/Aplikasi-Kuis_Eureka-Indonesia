package com.wisnuwahyudi.aplikasikuis.kategorisoal.network

import com.wisnuwahyudi.aplikasikuis.kategorisoal.model.ResponseCategory
import com.wisnuwahyudi.aplikasikuis.tampilankuis.model.ResponseSoalSoal
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface IService {

    @GET("getDataCategory.php")
    fun getDataCategory() : Flowable<ResponseCategory>

    @GET("getDataQuestion.php")
    fun getDataQuestion(
        @Query("id") id : Int?
    ) : Flowable<ResponseSoalSoal>

}