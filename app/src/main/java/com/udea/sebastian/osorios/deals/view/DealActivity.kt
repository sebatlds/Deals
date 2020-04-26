package com.udea.sebastian.osorios.deals.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.udea.sebastian.osorios.deals.R
import com.udea.sebastian.osorios.deals.databinding.ActivityDealBinding
import com.udea.sebastian.osorios.deals.model.Offer
import com.udea.sebastian.osorios.deals.viewmodel.DetalleViewModel
import kotlinx.android.synthetic.main.activity_deal.*
import kotlinx.android.synthetic.main.recycler_view_items.view.*

class DealActivity : AppCompatActivity() {

    private var detalleViewModel : DetalleViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deal)
        setupBinding(savedInstanceState)

    }


    fun setupBinding(savedInstanceState: Bundle?){
        var activityDetalleBinding : ActivityDealBinding = DataBindingUtil.setContentView(this,R.layout.activity_deal)
        detalleViewModel = ViewModelProvider(this).get(DetalleViewModel::class.java)

        activityDetalleBinding.model = detalleViewModel
        activityDetalleBinding.lifecycleOwner = this

        detalleViewModel?.setDetalleDeal(intent?.getSerializableExtra("deal") as Offer )

    }
}
