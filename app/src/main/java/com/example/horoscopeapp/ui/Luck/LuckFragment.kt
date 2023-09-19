package com.example.horoscopeapp.ui.Luck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.horoscopeapp.databinding.FragmentLuckBinding
import com.example.horoscopeapp.ui.BaseFragment

class LuckFragment : BaseFragment<FragmentLuckBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentLuckBinding
        get() = FragmentLuckBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}