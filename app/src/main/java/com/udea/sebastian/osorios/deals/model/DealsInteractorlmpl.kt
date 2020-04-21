package com.udea.sebastian.osorios.deals.model

import com.udea.sebastian.osorios.deals.DealsInterfaces
import com.udea.sebastian.osorios.deals.presenter.DealsPresenterlmpl

class DealsInteractorlmpl(var dealsPresenterlmpl: DealsPresenterlmpl) : DealsInterfaces.DealsInteractor {

    private var dealsRepository : DealsInterfaces.DealsRepository = DealsRepositorylmpl(dealsPresenterlmpl)

    override fun loadListDeals() {
        dealsRepository.loadListDeals()
    }
}