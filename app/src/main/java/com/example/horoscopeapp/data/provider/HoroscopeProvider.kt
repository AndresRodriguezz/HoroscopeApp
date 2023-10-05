package com.example.horoscopeapp.data.provider

import com.example.horoscopeapp.domain.model.HoroscopeInfo
import com.example.horoscopeapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries, Taurus, Gemini,
            Cancer, Leo, Virgo,
            Libra, Scorpio, Sagi,
            Capricorn, Aquarius,
            Pisces
        )
    }
}