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
import com.example.horoscopeapp.databinding.FragmentHoroscopeBinding
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Aquarius
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Aries
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Cancer
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Capricorn
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Gemini
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Leo
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Libra
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Pisces
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Sagi
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Scorpio
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Taurus
import com.example.horoscopeapp.domain.model.HoroscopeInfo.Virgo
import com.example.horoscopeapp.domain.model.HoroscopeModel
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
         val type = when(it) {
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagi -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }

            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToDetailFragment(type)
            )
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