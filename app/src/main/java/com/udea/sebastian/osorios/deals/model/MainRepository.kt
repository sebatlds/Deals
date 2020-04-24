package com.udea.sebastian.osorios.deals.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.udea.sebastian.osorios.deals.model.server.ApiService
import retrofit2.Call
import retrofit2.Response

class MainRepository : IMainRepository {

    private var deals = MutableLiveData<List<Offer>>()

    override fun getDeals(): MutableLiveData<List<Offer>> {
        return deals
    }

    override fun callDealsAPI() {
        var listDeals : ArrayList<Offer>? = ArrayList()
        val a = "f5095d2fb67cb04b21737be31cb7e811"
        val b = "fd6e3762e6026a11bea4433b27e198b8"

        ApiService.create()
            .getFeedDeals("79804727a58fcbb21f9a1ae686df6d46","json")
            .enqueue(object : retrofit2.Callback<Deals> {
                override fun onFailure(call: Call<Deals>, t: Throwable) {
                    Log.e("ERROR",t.message)
                }

                override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                    if (response.isSuccessful){
                       listDeals = response.body()!!.offers as ArrayList<Offer>
                    }
                    deals.value=listDeals
                }

            })

    }
}