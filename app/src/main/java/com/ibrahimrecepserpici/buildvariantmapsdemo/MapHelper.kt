package com.ibrahimrecepserpici.buildvariantmapsdemo

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment

class MapHelper {

    private lateinit var map : HuaweiMap

    private var mActivity : AppCompatActivity

    constructor(activity: AppCompatActivity)
    {
        mActivity = activity
        initMap()

    }
    fun initMap()
    {
        Log.e("TEST","initMap Called.")
        val mapFragment  = (mActivity.supportFragmentManager.findFragmentById(com.ibrahimrecepserpici.buildvariantmapsdemo.R.id.mapFragment) as SupportMapFragment)
        mapFragment.getMapAsync {
            map = it
        }


    }



}