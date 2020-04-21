package com.udea.sebastian.osorios.deals.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udea.sebastian.osorios.deals.R
import com.udea.sebastian.osorios.deals.model.Offer
import kotlinx.android.synthetic.main.recycler_view_items.view.*

class DealsAdapter(dealsList : ArrayList<Offer>) : RecyclerView.Adapter<DealsAdapter.DealsViewHolder>() {

    private var dealsList = ArrayList<Offer>()

    init{
        this.dealsList = dealsList
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : DealsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_items,parent,false)
        return DealsViewHolder(
            itemView
        )
    }

    override fun getItemCount() : Int = dealsList.size

    override fun onBindViewHolder(holder : DealsViewHolder, position : Int ){
        val deal = dealsList[position]
        holder.setDeal(deal)
    }

    class DealsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var deal : Offer? = null

        init{
            itemView.setOnClickListener(this)
        }

        fun setDeal(deal : Offer){
            this.deal = deal
            itemView.text_view_title.text = deal.title
            itemView.text_view_offer_value.text = deal.offerValue
            itemView.text_view_categories.text = deal.categories
            if(deal.imageUrl != ""){
                Picasso.get().load(deal.imageUrl).into(itemView.imageg_view)
            }

        }

        override fun onClick(view: View?) {34
           val intent = Intent(itemView.context,DealActivity::class.java)
            intent.putExtra("deal",deal)
            itemView.context.startActivity(intent)
        }
    }
}