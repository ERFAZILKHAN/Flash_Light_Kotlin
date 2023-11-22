package com.example.flash_light

import android.content.Context
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var cameraM:CameraManager
    private lateinit var powerBtn:ImageButton
    private var isFlash = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        powerBtn = findViewById(R.id.power)
        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        powerBtn.setOnClickListener { flashLightOnOrOff(it) }
    }

    private fun flashLightOnOrOff(v: View?) {
        if (!isFlash){
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,true)
            isFlash = true
            powerBtn.setImageResource(R.drawable.ic_power_on)
            textMessage("Flash Light is on",this)
        }
        else{
            val cameraListId = cameraM.cameraIdList[0]
            cameraM.setTorchMode(cameraListId,false)
            isFlash = false
            powerBtn.setImageResource(R.drawable.ic_power_off)
            textMessage("Flash Light is off",this)

        }

    }

    private fun textMessage(s: String,c:Context ) {
        Toast.makeText(c,s,Toast.LENGTH_SHORT).show()

    }
}