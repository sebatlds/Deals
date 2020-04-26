package com.udea.sebastian.osorios.deals.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udea.sebastian.osorios.deals.R
import com.udea.sebastian.osorios.deals.databinding.ActivityMainBinding
import com.udea.sebastian.osorios.deals.model.Offer
import com.udea.sebastian.osorios.deals.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private var mainViewModel : MainViewModel ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBindings(savedInstanceState)


    }

    fun setupBindings(savedInstanceState: Bundle?){
        var activityMainBinding : ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        activityMainBinding.model = mainViewModel

        setUpListUpdate()
    }

    fun setUpListUpdate(){

        mainViewModel?.callDeals()

        mainViewModel?.getDeals()?.observe(this, Observer {deal ->
            Log.d("Deal",deal[0].title)
            mainViewModel?.setDealsInDealsAdapter(deal)
        })
        setupListClick()
    }

    fun setupListClick(){
        mainViewModel?.getDealSelected()?.observe(this, Observer { deal ->
            val intent = Intent(this,DealActivity::class.java)
            intent.putExtra("deal",deal)
            startActivity(intent)
        })
    }

}
