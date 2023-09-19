package com.example.horoscopeapp.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.horoscopeapp.databinding.FragmentPalmistryBinding
import com.example.horoscopeapp.ui.BaseFragment

class PalmistryFragment : BaseFragment<FragmentPalmistryBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentPalmistryBinding
        get() = FragmentPalmistryBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}