package com.udea.sebastian.osorios.deals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.udea.sebastian.osorios.deals.model.Offer
import com.udea.sebastian.osorios.deals.viewmodel.MainViewModel
import com.udea.sebastian.osorios.deals.BR
import com.udea.sebastian.osorios.deals.R

class DealsAdapter(var mainViewModel: MainViewModel) :
    RecyclerView.Adapter<DealsAdapter.DealsViewHolder>() {

   private var dealsList : List<Offer> ?= null

    fun  setDealsList(deals : List<Offer>){
        this.dealsList = deals
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : DealsViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding : ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent,false)
        return DealsViewHolder(binding)
    }

    override fun getItemCount() : Int = dealsList?.size ?: 0

    override fun onBindViewHolder(holder : DealsViewHolder, position : Int ){
        holder.setDeal(mainViewModel,position)
    }
    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.recycler_view_items
    }

    class DealsViewHolder(binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        private var binding : ViewDataBinding? = null

        init{
            this.binding = binding
        }

        fun setDeal(mainViewModel: MainViewModel,position: Int) {
            binding?.setVariable(BR.model, mainViewModel)
            binding?.setVariable(BR.position, position)
        }


    }

}