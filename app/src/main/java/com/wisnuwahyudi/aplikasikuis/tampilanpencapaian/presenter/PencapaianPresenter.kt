package com.wisnuwahyudi.aplikasikuis.tampilanpencapaian.presenter

import android.content.Context
import android.util.Log
import com.wisnuwahyudi.aplikasikuis.kategorisoal.helper.SavedValueManager
import com.wisnuwahyudi.aplikasikuis.kategorisoal.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class PencapaianPresenter(val iviewPencapaian: IviewPencapaian) {

    fun resultExam(context: Context) {

        val session = SavedValueManager(context)

        if (session.idc == 1) {

            var cekTotalBenar: Int = 0
            var skor: Int = 0
            val jmlSalah: Int = 5
            val jawabanBenar = ArrayList<String>()
            val jawabanSiswa = ArrayList<String>()

            ConfigNetwork.getNetwork().getDataQuestion(session.idc)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isSuccess == true) {

                        for (i in 0..4) {
                            val da = it?.data?.get(i)
                            if (session.siswa_one == da?.answerB || session.siswa_two == da?.answerB ||
                                session.siswa_three == da?.answerD || session.siswa_four == da?.answerB
                                || session.siswa_five == da?.answerD
                            ) {
                                cekTotalBenar += 1
                            } else {
                                cekTotalBenar += 0
                            }
                        }

                        if (cekTotalBenar == 5) {
                            skor = 100
                        } else if (cekTotalBenar == 4) {
                            skor = 80
                        } else if (cekTotalBenar == 3) {
                            skor = 60
                        } else if (cekTotalBenar == 2) {
                            skor = 40
                        } else if (cekTotalBenar == 1) {
                            skor = 20
                        } else {
                            skor = 0
                        }
                        val totalSalah = (jmlSalah - cekTotalBenar)
                        jawabanSiswa.add(session.siswa_one.toString())
                        jawabanSiswa.add(session.siswa_two.toString())
                        jawabanSiswa.add(session.siswa_three.toString())
                        jawabanSiswa.add(session.siswa_four.toString())
                        jawabanSiswa.add(session.siswa_five.toString())

                        val noUrutSoal = ArrayList<Int>()

                        for (aa in 0..4) {
                            val datasistem = it.data?.get(aa)
                            when (aa) {
                                0 -> jawabanBenar.add(datasistem?.answerB.toString())
                                1 -> jawabanBenar.add(datasistem?.answerB.toString())
                                2 -> jawabanBenar.add(datasistem?.answerD.toString())
                                3 -> jawabanBenar.add(datasistem?.answerB.toString())
                                4 -> jawabanBenar.add(datasistem?.answerD.toString())
                            }
                            noUrutSoal.add(aa + 1)
                        }

                        iviewPencapaian.jawabanSiswaDanSistem(
                            jawabanSiswa,
                            jawabanBenar,
                            noUrutSoal
                        )
                        iviewPencapaian.calculateResult(cekTotalBenar, skor, totalSalah)

                    }
                }, {
                    Log.e("", "Error")
                })
        } else if (session.idc == 2) {

            var cekTotalBenar: Int = 0
            var skor: Int = 0
            val jmlSalah: Int = 5
            val jawabanBenar = ArrayList<String>()
            val jawabanSiswa = ArrayList<String>()

            ConfigNetwork.getNetwork().getDataQuestion(session.idc)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isSuccess == true) {

                        for (i in 0..4) {
                            val da = it?.data?.get(i)
                            if (session.siswa_one == da?.answerA || session.siswa_two == da?.answerD ||
                                session.siswa_three == da?.answerA || session.siswa_four == da?.answerD
                                || session.siswa_five == da?.answerC
                            ) {
                                cekTotalBenar += 1
                            } else {
                                cekTotalBenar += 0
                            }
                        }

                        if (cekTotalBenar == 5) {
                            skor = 100
                        } else if (cekTotalBenar == 4) {
                            skor = 80
                        } else if (cekTotalBenar == 3) {
                            skor = 60
                        } else if (cekTotalBenar == 2) {
                            skor = 40
                        } else if (cekTotalBenar == 1) {
                            skor = 20
                        } else {
                            skor = 0
                        }
                        val totalSalah = (jmlSalah - cekTotalBenar)
                        jawabanSiswa.add(session.siswa_one.toString())
                        jawabanSiswa.add(session.siswa_two.toString())
                        jawabanSiswa.add(session.siswa_three.toString())
                        jawabanSiswa.add(session.siswa_four.toString())
                        jawabanSiswa.add(session.siswa_five.toString())

                        val noUrutSoal = ArrayList<Int>()

                        for (aa in 0..4) {
                            val datasistem = it.data?.get(aa)
                            when (aa) {
                                0 -> jawabanBenar.add(datasistem?.answerA.toString())
                                1 -> jawabanBenar.add(datasistem?.answerD.toString())
                                2 -> jawabanBenar.add(datasistem?.answerA.toString())
                                3 -> jawabanBenar.add(datasistem?.answerD.toString())
                                4 -> jawabanBenar.add(datasistem?.answerC.toString())
                            }
                            noUrutSoal.add(aa + 1)
                        }

                        iviewPencapaian.jawabanSiswaDanSistem(
                            jawabanSiswa,
                            jawabanBenar,
                            noUrutSoal
                        )
                        iviewPencapaian.calculateResult(cekTotalBenar, skor, totalSalah)
                    }

                }, {

                })
        } else if (session.idc == 3){

            var cekTotalBenar: Int = 0
            var skor: Int = 0
            val jmlSalah: Int = 5
            val jawabanBenar = ArrayList<String>()
            val jawabanSiswa = ArrayList<String>()

            ConfigNetwork.getNetwork().getDataQuestion(session.idc)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isSuccess == true) {

                        for (i in 0..4) {
                            val da = it?.data?.get(i)
                            if (session.siswa_one == da?.answerD || session.siswa_two == da?.answerA ||
                                session.siswa_three == da?.answerC || session.siswa_four == da?.answerB
                                || session.siswa_five == da?.answerC
                            ) {
                                cekTotalBenar += 1
                            } else {
                                cekTotalBenar += 0
                            }
                        }

                        if (cekTotalBenar == 5) {
                            skor = 100
                        } else if (cekTotalBenar == 4) {
                            skor = 80
                        } else if (cekTotalBenar == 3) {
                            skor = 60
                        } else if (cekTotalBenar == 2) {
                            skor = 40
                        } else if (cekTotalBenar == 1) {
                            skor = 20
                        } else {
                            skor = 0
                        }
                        val totalSalah = (jmlSalah - cekTotalBenar)
                        jawabanSiswa.add(session.siswa_one.toString())
                        jawabanSiswa.add(session.siswa_two.toString())
                        jawabanSiswa.add(session.siswa_three.toString())
                        jawabanSiswa.add(session.siswa_four.toString())
                        jawabanSiswa.add(session.siswa_five.toString())

                        val noUrutSoal = ArrayList<Int>()

                        for (aa in 0..4) {
                            val datasistem = it.data?.get(aa)
                            when (aa) {
                                0 -> jawabanBenar.add(datasistem?.answerD.toString())
                                1 -> jawabanBenar.add(datasistem?.answerA.toString())
                                2 -> jawabanBenar.add(datasistem?.answerC.toString())
                                3 -> jawabanBenar.add(datasistem?.answerB.toString())
                                4 -> jawabanBenar.add(datasistem?.answerC.toString())
                            }
                            noUrutSoal.add(aa + 1)
                        }

                        iviewPencapaian.jawabanSiswaDanSistem(
                            jawabanSiswa,
                            jawabanBenar,
                            noUrutSoal
                        )
                        iviewPencapaian.calculateResult(cekTotalBenar, skor, totalSalah)
                    }

                }, {

                })
        }
    }
}