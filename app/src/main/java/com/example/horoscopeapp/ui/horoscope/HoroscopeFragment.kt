package com.example.horoscopeapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.horoscopeapp.databinding.FragmentHoroscopeBinding
import com.example.horoscopeapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopeFragment : BaseFragment<FragmentHoroscopeBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentHoroscopeBinding
        get() = FragmentHoroscopeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}