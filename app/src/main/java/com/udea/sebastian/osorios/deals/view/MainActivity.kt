package com.udea.sebastian.osorios.deals.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udea.sebastian.osorios.deals.DealsInterfaces
import com.udea.sebastian.osorios.deals.R
import com.udea.sebastian.osorios.deals.model.Offer
import com.udea.sebastian.osorios.deals.presenter.DealsPresenterlmpl

class MainActivity : AppCompatActivity(), DealsInterfaces.DealsView {

    private var presenter : DealsInterfaces.Presenter? = null
    private var listDeals : List<Offer>? = null
    private var dealsAdapter : DealsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = DealsPresenterlmpl(this)
        showListDeals()

    }

    fun showListDeals(){
        presenter?.loadListDeals()
    }

    override fun showResult(result: String) {

    }

    override fun showErrorLoadDeals(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun sendListDeals(deals: List<Offer>?) {
        this.listDeals = deals
        dealsAdapter = DealsAdapter(listDeals as ArrayList<Offer>)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            this,RecyclerView.VERTICAL,false
        )
        recyclerView.adapter = dealsAdapter
    }
}
