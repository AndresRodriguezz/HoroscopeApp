package com.example.horoscopeapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.horoscopeapp.databinding.FragmentDetailBinding
import com.example.horoscopeapp.ui.BaseFragment
import com.example.horoscopeapp.ui.util.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val viewModel: HoroscopeDetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override val bindingInflater: (LayoutInflater) -> FragmentDetailBinding
        get() = FragmentDetailBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when(it) {
                        is State.Loading -> loadingState(it.isLoading)
                        is State.Error -> errorState(it.error)
                        is State.Success -> successState(it.data)
                    }
                }
            }
        }
    }

    private fun loadingState(loading: Boolean) {
        TODO("Not yet implemented")
    }

    private fun errorState(error: String) {
        TODO("Not yet implemented")
    }

    private fun successState(data: Unit) {
        TODO("Not yet implemented")
    }
}