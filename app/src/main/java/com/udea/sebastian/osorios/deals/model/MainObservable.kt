package com.udea.sebastian.osorios.deals.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class MainObservable : BaseObservable() {

    private var mainRepository : IMainRepository = MainRepository()

    fun callDeals(){
        mainRepository.callDealsAPI()
    }

    fun getDeals(): MutableLiveData<List<Offer>>{
        return mainRepository.getDeals()
    }
}