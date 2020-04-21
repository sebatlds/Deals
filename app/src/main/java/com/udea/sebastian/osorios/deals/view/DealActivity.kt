package com.udea.sebastian.osorios.deals.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.udea.sebastian.osorios.deals.R
import com.udea.sebastian.osorios.deals.model.Offer
import kotlinx.android.synthetic.main.activity_deal.*
import kotlinx.android.synthetic.main.recycler_view_items.view.*

class DealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deal)
        val deal : Offer = intent?.getSerializableExtra("deal") as Offer
        updateUI(deal)
    }

    fun updateUI(deal : Offer){
        deal_title.text = deal.title
        deal_categories.text = deal.categories
        deal_description.text = deal.description
        deal_offer_text.text = deal.offerText
        deal_store.text = deal.store
        deal_url.text = deal.url
        deal_end_date.text = deal.endDate
        deal_start_date.text = deal.startDate + " - "
        if(deal.imageUrl != ""){
            Picasso.get().load(deal.imageUrl).into(deal_image)
        }
    }
}
