package com.udea.sebastian.osorios.deals

import com.udea.sebastian.osorios.deals.model.Offer

interface DealsInterfaces {

    interface DealsView{
        fun showResult(result : String)
        fun showErrorLoadDeals(message: String?)
        fun sendListDeals(deals: List<Offer>?)
    }

    interface Presenter{
        fun loadListDeals()
        fun sendListDeal(result: List<Offer>?)
        fun showErrorLoadDeals(message : String?)
    }

    interface DealsModelServices{
        fun loadListDeals()
    }

    interface DealsInteractor{
        fun loadListDeals()

    }

    interface DealsRepository{
        fun loadListDeals()

    }
}