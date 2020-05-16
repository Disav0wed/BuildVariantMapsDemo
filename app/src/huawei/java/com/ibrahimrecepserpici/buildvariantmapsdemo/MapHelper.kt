package com.ibrahimrecepserpici.buildvariantmapsdemo

import androidx.appcompat.app.AppCompatActivity
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.MarkerOptions
import com.ibrahimrecepserpici.buildvariantmapsdemo.R

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
        val mapFragment  = (mActivity.supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment)
        mapFragment.getMapAsync {
            map = it
            map.addMarker(MarkerOptions().position(LatLng(6.2186, -75.5742)).title("HUAWEI")).snippet = "Hello From Maps!"
        }
    }
}