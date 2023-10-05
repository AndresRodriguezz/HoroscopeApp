package com.example.horoscopeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.horoscopeapp.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentDetailBinding
        get() = FragmentDetailBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}