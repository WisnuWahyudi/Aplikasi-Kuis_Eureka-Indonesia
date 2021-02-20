package com.wisnuwahyudi.aplikasikuis.tampilankuis.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.wisnuwahyudi.aplikasikuis.databinding.FragmentSoalFiveBinding
import com.wisnuwahyudi.aplikasikuis.kategorisoal.helper.SavedValueManager
import com.wisnuwahyudi.aplikasikuis.kategorisoal.model.DataItem
import com.wisnuwahyudi.aplikasikuis.kategorisoal.network.ConfigNetwork
import com.wisnuwahyudi.aplikasikuis.tampilankuis.view.TampilanKuisActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Soal_Five_Fragment : Fragment() {


    private lateinit var binding : FragmentSoalFiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSoalFiveBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accData = activity?.intent?.getParcelableExtra<DataItem>(TampilanKuisActivity.key_id_category)

        ConfigNetwork.getNetwork().getDataQuestion(accData?.iD?.toInt())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it.isSuccess == true){
                    val da =  it?.data?.get(4)

                    binding.txtSoal.text = da?.questionText
                    binding.cbA.text = da?.answerA
                    binding.cbB.text = da?.answerB
                    binding.cbC.text = da?.answerC
                    binding.cbD.text = da?.answerD

                    binding.imgSoal.visibility = View.VISIBLE

                    Glide.with(requireActivity())
                        .load(da?.questionImage)
                        .into(binding.imgSoal)

                    val session = SavedValueManager(context)

                    binding.cbA.setOnClickListener { if(binding.cbA.isChecked){ session.siswa_five=da?.answerA} }
                binding.cbB.setOnClickListener {if (binding.cbB.isChecked)session.siswa_five=da?.answerB }
                    binding.cbC.setOnClickListener {if (binding.cbC.isChecked)session.siswa_five=da?.answerC }
                    binding.cbD.setOnClickListener {if (binding.cbD.isChecked)session.siswa_five=da?.answerD }

                }else{
                    binding.txtSoal.text = it.message.toString()
                }
            },{

            })
    }

}