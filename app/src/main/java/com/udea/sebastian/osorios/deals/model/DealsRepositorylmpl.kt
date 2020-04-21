package com.udea.sebastian.osorios.deals.model

import com.udea.sebastian.osorios.deals.DealsInterfaces
import retrofit2.Call
import retrofit2.Response

class DealsRepositorylmpl(var dealsPresenter: DealsInterfaces.Presenter) : DealsInterfaces.DealsRepository {

    override fun loadListDeals() {
        var listDeals : List<Offer>
        ApiService
            .create()
            .getFeedDeals("f5095d2fb67cb04b21737be31cb7e811","json")
            .enqueue(object : retrofit2.Callback<Deals> {
                override fun onFailure(call: Call<Deals>, t: Throwable) {
                    dealsPresenter.showErrorLoadDeals(t.message)
                }

                override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                    if (response.isSuccessful){
                        dealsPresenter.sendListDeal(response.body()?.offers)
                    }

                }

            })
    }

}