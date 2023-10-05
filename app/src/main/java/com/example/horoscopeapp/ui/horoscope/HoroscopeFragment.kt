package com.example.horoscopeapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horoscopeapp.R
import com.example.horoscopeapp.databinding.FragmentHoroscopeBinding
import com.example.horoscopeapp.ui.BaseFragment
import com.example.horoscopeapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : BaseFragment<FragmentHoroscopeBinding>() {

    private val viewModel: HoroscopeViewModel by viewModels()
    private lateinit var  horoscopeAdapter: HoroscopeAdapter

    override val bindingInflater: (LayoutInflater) -> FragmentHoroscopeBinding
        get() = FragmentHoroscopeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter {
            findNavController().navigate(R.id.action_horoscopeFragment_to_detailFragment)
        }

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.horoscope.collect {
                   horoscopeAdapter.updateList(it)
                }
            }
        }
    }
}