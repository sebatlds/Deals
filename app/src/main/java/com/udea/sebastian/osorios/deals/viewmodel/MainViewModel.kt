package com.udea.sebastian.osorios.deals.viewmodel

import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import com.udea.sebastian.osorios.deals.R
import com.udea.sebastian.osorios.deals.model.MainObservable
import com.udea.sebastian.osorios.deals.model.Offer
import com.udea.sebastian.osorios.deals.view.DealsAdapter
import com.udea.sebastian.osorios.deals.view.MainActivity
import de.hdodenhof.circleimageview.CircleImageView

class MainViewModel : ViewModel() {

    private var mainObservable : MainObservable = MainObservable()
    private var dealsAdapter : DealsAdapter ? = null
    private var dealSelected : MutableLiveData<Offer> = MutableLiveData()
    private var mainActivity : MainActivity = MainActivity()

    fun callDeals(){
        mainObservable.callDeals()
    }

    fun getDeals(): MutableLiveData<List<Offer>> {
        return mainObservable.getDeals()
    }

    fun setDealsInDealsAdapter(deals : List<Offer>){
        dealsAdapter?.setDealsList(deals)
        dealsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerDealsAdapter(): DealsAdapter?{
        dealsAdapter = DealsAdapter(this)
        return dealsAdapter
    }

    fun getDealSelected() : MutableLiveData<Offer>{
        return dealSelected
    }

    fun onItemClick(position: Int){
        val deal = getDeal(position)
        dealSelected.value = deal
      //  mainActivity.setupListClick(deal!!)
    }

    fun getDeal(position : Int) : Offer?{
        var deal : List<Offer>? = mainObservable.getDeals().value
        return deal?.get(position)
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String){
            if(imageUrl != ""){
                Picasso.get().load(imageUrl).into(imageView)
            }else{
                imageView.setImageResource(R.drawable.circle_cropped)
            }
        }
    }

}