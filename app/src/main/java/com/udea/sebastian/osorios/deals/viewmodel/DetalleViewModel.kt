package com.udea.sebastian.osorios.deals.viewmodel

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import com.udea.sebastian.osorios.deals.R
import com.udea.sebastian.osorios.deals.model.Offer
import de.hdodenhof.circleimageview.CircleImageView

class DetalleViewModel: ViewModel() {

    private var deal : MutableLiveData<Offer> = MutableLiveData()

    fun setDetalleDeal(deal : Offer){
        this.deal.value = deal
    }

    fun getDeal() : MutableLiveData<Offer> = deal

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: CircleImageView,imageUrl : String){
            if(!imageUrl.equals("")){
                Picasso.get().load(imageUrl).into(imageView)
            }else{
                imageView.setImageResource(R.drawable.circle_cropped)
            }
        }
    }

}