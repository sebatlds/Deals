package com.udea.sebastian.osorios.deals.model

import androidx.lifecycle.MutableLiveData

interface IMainRepository {
    fun callDealsAPI()
    fun getDeals() : MutableLiveData<List<Offer>>
}