package com.example.contreyandflag

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.contreyandflag.adapter.CuontryAdapter
import com.example.contreyandflag.databinding.FragmentCountryFlagBinding

// تربيطة الريسايكل
class CountryFlag : Fragment() {
  private var binding:FragmentCountryFlagBinding?=null
  private val sharedViewModel:FlagViewModel by activityViewModels()
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentCountryFlagBinding.inflate(inflater,container,false)
    binding?.lifecycleOwner = this
    binding!!.recyclerView.adapter = CuontryAdapter()
    binding?.viweModel = FlagViewModel()
    return binding?.root
  }



  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}

//kk