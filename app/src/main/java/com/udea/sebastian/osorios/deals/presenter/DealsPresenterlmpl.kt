package com.udea.sebastian.osorios.deals.presenter

import com.udea.sebastian.osorios.deals.DealsInterfaces
import com.udea.sebastian.osorios.deals.model.DealsInteractorlmpl
import com.udea.sebastian.osorios.deals.model.Offer

class DealsPresenterlmpl(var dealsView: DealsInterfaces.DealsView) : DealsInterfaces.Presenter {

    private var dealsInteractor : DealsInterfaces.DealsInteractor =  DealsInteractorlmpl(this)

    override fun loadListDeals() {
        dealsInteractor.loadListDeals()
    }

    override fun sendListDeal(deals: List<Offer>?) {
        dealsView.sendListDeals(deals)
    }

    override fun showErrorLoadDeals(message: String?) {
        dealsView.showErrorLoadDeals(message)
    }


}