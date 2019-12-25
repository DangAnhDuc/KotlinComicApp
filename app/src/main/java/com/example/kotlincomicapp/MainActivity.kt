package com.example.kotlincomicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlincomicapp.Common.Common
import com.example.kotlincomicapp.Retrofit.IComicAPI
import com.example.kotlincomicapp.Service.PicassoImageLoadingService
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import ss.com.bannerslider.Slider

class MainActivity : AppCompatActivity() {
    internal  var compositeDisposable= CompositeDisposable()
    internal lateinit var iComicAPI: IComicAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iComicAPI= Common.api
        Slider.init(PicassoImageLoadingService(this))

        recyclerview_comic.setHasFixedSize(true)
        recyclerview_comic.layoutManager= GridLayoutManager(this,2)

        swipe_refresh.setColorSchemeResources(R.color.colorPrimary,android.R.color.holo_orange_dark,android.R.color.background_dark)
        swipe_refresh.setOnRefreshListener {
            if(Common.isConnectedToInternet(baseContext))
        }
    }
}
