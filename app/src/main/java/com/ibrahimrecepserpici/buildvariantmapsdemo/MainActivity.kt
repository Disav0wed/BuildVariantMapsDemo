package com.ibrahimrecepserpici.buildvariantmapsdemo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 376
    private lateinit var mapHelper: MapHelper
    private val RUNTIME_PERMISSIONS = arrayOf<String>(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.INTERNET
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.ibrahimrecepserpici.buildvariantmapsdemo.R.layout.activity_main)

        if (!hasPermissions(this, *RUNTIME_PERMISSIONS ))
        {
            askForPermissions()
        }else
        {
            mapHelper =
                MapHelper(
                    this
                )
        }
    }

    private  fun askForPermissions()
    {
        ActivityCompat.requestPermissions(this, RUNTIME_PERMISSIONS, REQUEST_CODE)
    }

    private fun hasPermissions(
        context: Context, vararg permissions: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    Log.e("NEED PERMISSION",permission)
                    return false
                }
            }
        }
        return true
    }

    /**This method will be triggered after the permissions asked.**/
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_CODE)
        {
            /**Recreate the whole activity**/
            this.recreate()
        }
    }
}
